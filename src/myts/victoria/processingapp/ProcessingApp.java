package myts.victoria.processingapp;

import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.Color;
import myts.victoria.config.ConfigManager;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.views.ProcessingView;
import processing.core.PApplet;

class ProcessingApp extends PApplet implements IProcessingApp {

    private static ProcessingApp processingApp;
    private final VisualizationConfig<Integer> config;
    private ProcessingView<?> view;

    private ProcessingApp() {
        this.config = ConfigManager.<Integer>getInstance().getConfig();
    }

    public static ProcessingApp getInstance() {
        if (processingApp == null) {
            processingApp = new ProcessingApp();
        }
        return processingApp;
    }

    private void setBackground(Color color) {
        background(color.getR(), color.getG(), color.getB());
    }

    @Override
    public void draw() {
        if (view != null) {
            setBackground(config.getBackgroundColor());
            view.display();
        }
    }

    @Override
    public void redraw(RedrawArguments arguments) {
        if (view != null) {
            view.setArguments(arguments);
            redraw();
        }
    }

    @Override
    public void setView(ProcessingView<?> view) {
        this.view = view;
    }

    @Override
    public void setup() {
        noLoop();
        setBackground(config.getBackgroundColor());
    }

    @Override
    public void settings() {
        size(config.getWindowSize(), config.getWindowSize());
    }
}
