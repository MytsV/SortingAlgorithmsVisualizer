package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.OnConfigurationCallback;
import myts.victoria.sortings.SortManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfigurationFrame extends JFrame {

    public ConfigurationFrame(VisualizationConfig<Integer> config, OnConfigurationCallback callback) {
        setSize(config.getWindowSize(), config.getWindowSize());

        Container container = getContentPane();
        container.setLayout(new GridLayout(10, 1));

        JPanel panel = new JPanel();
        panel.add(new ConfigurationSlider(config));
        panel.add(new ConfigurationTypesSelection(config, new SortManager()));

        container.add(panel);

        FieldModel model = new FieldModel();

        ConfigurationList<Integer> list = new ConfigurationList<>();
        ConfigurationListField field = new ConfigurationListField(model);

        Runnable onAddButtonClick = () -> {
            try {
                list.add(Integer.parseInt(model.getText()));
                config.setList(list.getList());
                field.setText("");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "You should input a number");
            }
        };

        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onAddButtonClick.run();
                }
            }
        });

        container.add(list);
        container.add(field);
        container.add(new ConfigurationListButton(onAddButtonClick));

        container.add(new ConfigurationListRemoveButton(() -> {
            list.remove(list.getSelectedValue());
            config.setList(list.getList());
        }));

        container.add(new ConfigurationOrder<>(config));

        container.add(new ConfigurationButton(config, callback));
    }
}
