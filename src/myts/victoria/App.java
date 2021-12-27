package myts.victoria;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.processingapp.ProcessingApp;
import myts.victoria.sortings.Sort;
import myts.victoria.views.ListViewInteger;

//creates and runs processing view
public class App {

    private final ProcessingApp processingApp;
    private final VisualizationConfig<Integer> config;

    public App(ProcessingApp processingApp, VisualizationConfig<Integer> config) {
        this.processingApp = processingApp;
        this.config = config;
    }

    public void run() {
        if (config.getList() == null || config.getSort() == null) {
            throw new IllegalArgumentException();
        }
        ListViewInteger view = new ListViewInteger(processingApp);
        processingApp.setView(view);
        //creating a new thread is essential for the correct program behaviour
        SortThread<Integer> sortThread = new SortThread<>(getSort());
        sortThread.start();
    }

    private Sort<Integer> getSort() {
        Sort<Integer> sort = config.getSort();
        sort.setCallback(this::callback);
        sort.setList(config.getList());
        return sort;
    }

    //callback that will be called when the view should be redrawn
    private void callback(RedrawArguments arguments) {
        processingApp.redraw(arguments);
        try {
            //if arguments are not defined, the sorting algorithm has finished running
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

}
