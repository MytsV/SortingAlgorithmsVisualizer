package myts.victoria.configapp.elements;

import myts.victoria.config.CompareTypeManager;
import myts.victoria.config.VisualizationConfig;

import javax.swing.*;

public class ConfigurationOrder extends JPanel {

    private final String ascendingName = "Ascending";
    private final String descendingName = "Descending";

    //TODO: fix warnings
    public ConfigurationOrder(VisualizationConfig<? extends Comparable> config) {
        ButtonGroup group = new ButtonGroup();

        var compareTypes = CompareTypeManager.getInstance().getCompareTypes();

        JRadioButton ascending = new JRadioButton(ascendingName);
        JRadioButton descending = new JRadioButton(descendingName);

        ascending.setSelected(true);
        setInitial(config);

        ascending.addActionListener((event) -> config.setCompareMatch(compareTypes.get(ascendingName)));
        descending.addActionListener((event) -> config.setCompareMatch(compareTypes.get(descendingName)));

        group.add(ascending);
        group.add(descending);

        add(ascending);
        add(descending);
    }

    private void setInitial(VisualizationConfig<? extends Comparable> config) {
        config.setCompareMatch(CompareTypeManager.getInstance().getCompareTypes().get(ascendingName));
    }


}
