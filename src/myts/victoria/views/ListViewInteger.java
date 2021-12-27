package myts.victoria.views;

import myts.victoria.config.Color;
import myts.victoria.processingapp.ProcessingApp;

import java.util.Collections;
import java.util.function.Consumer;

public class ListViewInteger extends ListView<Integer> {

    public ListViewInteger(ProcessingApp applet) {
        super(applet, applet.getConfig());
    }

    public void display() {
        iterateElements(idx -> {
            //if the current element was acted upon
            if (arguments != null && arguments.getChangeIndices().contains(idx)) {
                switch (arguments.getCallbackType()) {
                    case DIVIDING -> setFill(config.getMergeColor());
                    case SEARCHING -> setFill(config.getSearchColor());
                    case SWAPPING -> setFill(config.getSwapColor());
                }
            }
        });
    }

    private void iterateElements(Consumer<Integer> callback) {
        for (int i = 0; i < config.getList().size(); i++) {
            setFill(config.getMainColor());

            float ySize = getYElementSize(config.getList().get(i));

            callback.accept(i);

            //draws an element
            app.rect(i * getXSize(), app.height - ySize, getXSize(), ySize);
        }
    }

    private void setFill(Color color) {
        app.fill(color.getR(), color.getG(), color.getB());
    }

    @Override
    protected float getYElementSize(Integer element) {
        return getYSize() * element;
    }

    @Override
    protected float getYSize() {
        return (float) config.getWindowSize() / Collections.max(config.getList());
    }
}
