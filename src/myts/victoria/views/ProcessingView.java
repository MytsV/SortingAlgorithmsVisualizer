package myts.victoria.views;

import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;

public abstract class ProcessingView<T extends Comparable<T>> {

    protected RedrawArguments arguments;
    protected final VisualizationConfig<T> config;

    public ProcessingView(VisualizationConfig<T> config) {
        this.config = config;
    }

    public void setArguments(RedrawArguments arguments) {
        this.arguments = arguments;
    }

    public abstract void display();

}
