package myts.victoria.configapp.elements;

import myts.victoria.config.CompareTypeManager;
import myts.victoria.config.VisualizationConfig;

import javax.swing.*;

public class ConfigurationOrder<T extends Comparable<T>> extends JPanel {

    private final String ascendingName = "Ascending";
    private final String descendingName = "Descending";
    private final CompareTypeManager<T> compareTypeManager;

    public ConfigurationOrder(VisualizationConfig<T> config) {
        ButtonGroup group = new ButtonGroup();
        compareTypeManager = new CompareTypeManager<>();

        var compareTypes = compareTypeManager.getCompareTypes();

        JRadioButton ascending = new JRadioButton(ascendingName);
        JRadioButton descending = new JRadioButton(descendingName);

        ascending.setSelected(true);
        setInitial(config);

        ascending.addActionListener((event) -> config.setCompareOrder(compareTypes.get(ascendingName)));
        descending.addActionListener((event) -> config.setCompareOrder(compareTypes.get(descendingName)));

        group.add(ascending);
        group.add(descending);

        add(ascending);
        add(descending);
    }

    private void setInitial(VisualizationConfig<T> config) {
        config.setCompareOrder(compareTypeManager.getCompareTypes().get(ascendingName));
    }


}
