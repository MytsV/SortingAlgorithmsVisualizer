package myts.victoria.configapp;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.elements.ConfigurationFrame;

public class ConfigurationApp {

    final private VisualizationConfig<Integer> config;
    final private OnConfigurationCallback callback;

    public ConfigurationApp(VisualizationConfig<Integer> config, OnConfigurationCallback callback) {
        this.config = config;
        this.callback = callback;
    }

    public void run() {
        ConfigurationFrame frame = new ConfigurationFrame(config, callback);
        frame.setVisible(true);
    }

}
