package myts.victoria.configapp.elements;

import myts.victoria.config.DelayConfig;
import myts.victoria.config.VisualizationConfig;

import javax.swing.*;

public class ConfigurationSlider extends JSlider {

    public ConfigurationSlider(VisualizationConfig<?> config) {
        setMinimum(DelayConfig.MIN);
        setMaximum(DelayConfig.MAX);

        setValue(DelayConfig.MIN);
        setPaintLabels(true);
        setMajorTickSpacing(DelayConfig.TICK_SPACING);
        setPaintTicks(true);

        setInitial(config);

        addChangeListener((event) -> config.setDelay(getValue() * DelayConfig.MULTIPLIER));
    }

    private void setInitial(VisualizationConfig<?> config) {
        config.setDelay(100);
    }

}
