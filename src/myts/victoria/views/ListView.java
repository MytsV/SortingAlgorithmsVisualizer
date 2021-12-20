package myts.victoria.views;

import processing.core.PApplet;

public abstract class ListView<T extends Comparable<T>> extends ProcessingView<T> {

    protected PApplet app;

    public ListView(PApplet applet) {
        super();
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
