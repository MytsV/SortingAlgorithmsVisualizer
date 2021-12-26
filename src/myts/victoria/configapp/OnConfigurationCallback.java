package myts.victoria.configapp;

import myts.victoria.config.VisualizationConfig;

@FunctionalInterface
public interface OnConfigurationCallback {

    void run(VisualizationConfig<Integer> config);

}
