package myts.victoria.views;

import myts.victoria.config.VisualizationConfig;
import processing.core.PApplet;

public abstract class ListView<T extends Comparable<T>> extends ProcessingView<T> {

    protected final PApplet app;

    public ListView(PApplet applet, VisualizationConfig<T> config) {
        super(config);
        this.app = applet;
    }

    public abstract void display();

    //height for a definite element
    protected abstract float getYElementSize(T element);

    protected float getXSize() {
        return (float) app.width / config.getList().size();
    }

    //height for one element unit
    protected float getYSize() {
        return 20;
    }

}
