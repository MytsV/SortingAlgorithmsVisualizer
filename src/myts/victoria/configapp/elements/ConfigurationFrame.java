package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.configapp.OnConfigurationCallback;
import myts.victoria.sortings.SortManager;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfigurationFrame extends JFrame {

    private final int borderSize = 4;

    private final VisualizationConfig<Integer> config;
    private final OnConfigurationCallback callback;

    public ConfigurationFrame(VisualizationConfig<Integer> config, OnConfigurationCallback callback) {
        this.config = config;
        this.callback = callback;

        setSize(config.getWindowSize(), config.getWindowSize());

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        add(getTopPane());
        add(getBottomPane());
    }

    private JPanel getTopPane() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(0, borderSize * 2, 0, borderSize * 2));
        panel.setPreferredSize(new Dimension(config.getWindowSize(), getTopPaneHeight()));
        panel.setLayout(new GridLayout(1, 2));

        panel.add(getDelayPane());
        panel.add(getTypePane());

        return panel;
    }

    private JPanel getDelayPane() {
        JPanel panel = new JPanel();
        panel.setBorder(getTitledBorder("Delay"));
        panel.setLayout(new FlowLayout());
        panel.add(new ConfigurationSlider(config));

        return panel;
    }

    private JPanel getTypePane() {
        JPanel panel = new JPanel();
        panel.setBorder(getTitledBorder("Type"));
        panel.setLayout(new FlowLayout());
        panel.add(new ConfigurationOrder<>(config));

        return panel;
    }

    private int getTopPaneHeight() {
        return (int) (config.getWindowSize() * 0.25);
    }

    private JPanel getBottomPane() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(config.getWindowSize(), getBottomPaneHeight()));
        panel.setBorder(new EmptyBorder(0, borderSize * 2, borderSize * 2, borderSize * 2));
        panel.setLayout(new GridLayout(1, 2));

        panel.add(getListPane());
        panel.add(getRightBottomPane());

        return panel;
    }

    private int getBottomPaneHeight() {
        return (int) (config.getWindowSize() * 0.67);
    }

    private JPanel getListPane() {
        JPanel panel = new JPanel();
        panel.setBorder(getTitledBorder("List"));
        panel.setLayout(new FlowLayout());

        FieldModel model = new FieldModel();

        ConfigurationList<Integer> list = new ConfigurationList<>();
        ConfigurationListField field = new ConfigurationListField(model);

        Runnable onAddButtonClick = getOnAddButtonClick(list, model, field);

        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    onAddButtonClick.run();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(getScrollPaneSize());

        panel.add(scrollPane);
        panel.add(field);
        panel.add(new ConfigurationListButton(onAddButtonClick));
        panel.add(new ConfigurationListRemoveButton(() -> {
            list.remove(list.getSelectedValue());
            config.setList(list.getList());
        }));

        return panel;
    }

    private Dimension getScrollPaneSize() {
        return new Dimension((int) (config.getWindowSize()/2 * 0.84), (int) (config.getWindowSize()/2 * 0.88));
    }

    private Runnable getOnAddButtonClick(ConfigurationList<Integer> list, FieldModel model, ConfigurationListField field) {
        return () -> {
            try {
                list.add(Integer.parseInt(model.getText()));
                config.setList(list.getList());
                field.setText("");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "You should input a number");
            }
        };
    }

    private JPanel getRightBottomPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel sortPane = getSortPane();

        panel.add(sortPane);
        panel.add(new JPanel().add(new ConfigurationButton(config, (config) -> {
            if (config.getList().size() >= 3) {
                callback.run(config);
            } else {
                JOptionPane.showMessageDialog(this, "The list size should be 3 or greater");
            }
        })));

        return panel;
    }

    private JPanel getSortPane() {
        JPanel panel = new JPanel();
        panel.setBorder(getTitledBorder("Sort type"));
        panel.setLayout(new FlowLayout());
        panel.add(new ConfigurationSortSelection(config, new SortManager<>()));
        return panel;
    }

    private Border getTitledBorder(String title) {
        return new CompoundBorder(new TitledBorder(title), new EmptyBorder(borderSize, borderSize, borderSize, borderSize));
    }

}