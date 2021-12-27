package myts.victoria;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.processingapp.ProcessingApp;
import myts.victoria.sortings.Sort;
import myts.victoria.views.ListViewInteger;

public class App {

    private final ProcessingApp processingApp;
    private final VisualizationConfig<Integer> config;

    public App(ProcessingApp processingApp, VisualizationConfig<Integer> config) {
        this.processingApp = processingApp;
        this.config = config;
    }

    private void callback(RedrawArguments arguments) {
        processingApp.redraw(arguments);
        try {
            if (arguments != null) {
                Thread.sleep(getDelay(arguments.getCallbackType()));
            }
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private int getDelay(CallbackType type) {
        int delay = config.getDelay();
        return type == CallbackType.SWAPPING ? delay * 2 : delay;
    }

    private Sort<Integer> getSort() {
        Sort<Integer> sort = config.getSort();
        sort.setCallback(this::callback);
        sort.setList(config.getList());
        return sort;
    }

    public void run() {
        if (config.getList() == null || config.getSort() == null) {
            throw new IllegalArgumentException();
        }
        ListViewInteger view = new ListViewInteger(processingApp);
        processingApp.setView(view);
        SortThread<Integer> sortThread = new SortThread<>(getSort());
        sortThread.start();
    }

}
