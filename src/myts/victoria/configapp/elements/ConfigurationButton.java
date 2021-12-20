package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.OnConfigurationCallback;

import javax.swing.*;
import java.awt.*;

public class ConfigurationButton extends JButton {

    public ConfigurationButton(VisualizationConfig<?> config, OnConfigurationCallback callback) {
        super("Submit");
        addActionListener((event) -> {
            if (config.getList() == null || config.getList().isEmpty()) {
                JOptionPane.showMessageDialog(this.getParent(), "The list should not be empty");
            } else {
                callback.run(config);
            }
        });
        setPreferredSize(new Dimension(100, 100));
    }

}
