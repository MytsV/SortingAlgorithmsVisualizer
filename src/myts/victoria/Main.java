package myts.victoria;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.Configurator;
import myts.victoria.processingapp.ProcessingApp;
import processing.core.PApplet;

public class Main {

    private static void runProcessingApp(VisualizationConfig<Integer> config) {
        String[] processingArgs = {"Main"};
        ProcessingApp applet = new ProcessingApp(config);
        PApplet.runSketch(processingArgs, applet);
        App app = new App(applet, config);
        app.run();
    }

    public static void main(String... args) {
        Configurator configurator = new Configurator(Main::runProcessingApp);
        configurator.start();
    }

}
