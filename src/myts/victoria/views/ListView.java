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

    protected abstract float getYElementSize(T element);

    protected float getXSize() {
        return (float) app.width / config.getList().size();
    }

    protected float getYSize() {
        return 20;
    }

}
