package myts.victoria;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.Configurator;
import myts.victoria.processingapp.IProcessingApp;
import myts.victoria.processingapp.ProcessingAppFactory;
import processing.core.PApplet;

public class Main {

    private static void runProcessingApp(VisualizationConfig<Integer> config) {
        String[] processingArgs = {"Main"};
        PApplet applet = ProcessingAppFactory.getApp(config);
        PApplet.runSketch(processingArgs, applet);
        IProcessingApp processingApp = (IProcessingApp) applet;
        App app = new App(processingApp, config);
        app.run();
    }

    public static void main(String... args) {
        Configurator configurator = new Configurator(Main::runProcessingApp);
        configurator.start();
    }

}
