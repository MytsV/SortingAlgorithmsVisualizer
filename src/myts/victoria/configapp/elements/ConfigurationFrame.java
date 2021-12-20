package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.OnConfigurationCallback;
import myts.victoria.sortings.SortManager;

import javax.swing.*;
import java.awt.*;

public class ConfigurationFrame<T extends Comparable<T>> extends JFrame {

    public ConfigurationFrame(VisualizationConfig<T> config, OnConfigurationCallback callback) {
        setSize(config.getWindowSize(), config.getWindowSize());

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        container.add(new JLabel("Delay"));
        container.add(new ConfigurationSlider(config));
        container.add(new ConfigurationTypesSelection(config, new SortManager()));

        FieldModel model = new FieldModel();

        ConfigurationList<T> list = new ConfigurationList<T>();

        container.add(list);
        container.add(new ConfigurationListField(model));
        container.add(new ConfigurationListButton(() -> {
            try {
                list.add(Integer.parseInt(model.getText()));
                config.setList(list.getList());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "You should input a number");
            }
        }));
        container.add(new ConfigurationListRemoveButton(() -> {
            list.remove(list.getSelectedValue());
            config.setList(list.getList());
        }));

        container.add(new ConfigurationOrder(config));

        container.add(new ConfigurationButton(config, callback));
    }

}
