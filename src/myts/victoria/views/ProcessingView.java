package myts.victoria.views;

import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.ConfigManager;
import myts.victoria.config.VisualizationConfig;

public abstract class ProcessingView<T extends Comparable<T>> {

    protected RedrawArguments arguments;
    protected VisualizationConfig<T> config;
    public ProcessingView() {
        this.config = (VisualizationConfig<T>) ConfigManager.getInstance().getConfig();
    }

    public void setArguments(RedrawArguments arguments) {
        this.arguments = arguments;
    }

    public abstract void display();

}
