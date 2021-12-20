package myts.victoria.configapp;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.elements.ConfigurationFrame;

public class ConfigurationApp<T extends Comparable<T>> {

    final private VisualizationConfig<T> config;
    final private OnConfigurationCallback callback;

    public ConfigurationApp(VisualizationConfig<T> config, OnConfigurationCallback callback) {
        this.config = config;
        this.callback = callback;
    }

    public void run() {
        ConfigurationFrame<T> frame = new ConfigurationFrame<>(config, callback);
        frame.setVisible(true);
    }

}
