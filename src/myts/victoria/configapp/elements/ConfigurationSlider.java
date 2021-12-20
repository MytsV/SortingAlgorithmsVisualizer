package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;

import javax.swing.*;

public class ConfigurationSlider extends JSlider {

    public ConfigurationSlider(VisualizationConfig<?> config) {
        //TODO: remove hard code
        setMinimum(1);
        setMaximum(10);

        setValue(1);
        setPaintLabels(true);
        setMajorTickSpacing(1);
        setPaintTicks(true);

        setInitial(config);

        addChangeListener((event) -> config.setDelay(getValue() * 100));
    }

    private void setInitial(VisualizationConfig<?> config) {
        config.setDelay(100);
    }

}
