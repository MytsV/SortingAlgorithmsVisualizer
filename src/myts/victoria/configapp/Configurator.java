package myts.victoria.configapp;

import myts.victoria.config.VisualizationConfig;

public class Configurator {

    private final OnConfigurationCallback callback;

    public Configurator(OnConfigurationCallback callback) {
        this.callback = callback;
    }

    public void start() {
        VisualizationConfig<?> config = new VisualizationConfig<>();
        setStaticConfigs(config);
        ConfigurationApp<?> configurationApp = new ConfigurationApp<>(config, callback);
        configurationApp.run();
    }

    private void setStaticConfigs(VisualizationConfig<?> config) {
        FileConfiguration configuration = new FileConfiguration(config);
        configuration.load();
    }

}
