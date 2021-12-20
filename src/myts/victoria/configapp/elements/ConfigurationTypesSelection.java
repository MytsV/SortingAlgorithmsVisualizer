package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;
import myts.victoria.sortings.SortManager;
import myts.victoria.sortings.concrete.logarithmic.MergeSort;

import javax.swing.*;

public class ConfigurationTypesSelection extends JComboBox<String> {

    public ConfigurationTypesSelection(VisualizationConfig<?> config, SortManager sortManager) {
        super(getSortArray(sortManager));

        setInitial(config);

        addActionListener((event) -> config.setSort(getSort(sortManager.getSorts().get(getSelectedItem()))));
    }

    private static String[] getSortArray(SortManager sortManager) {
        return sortManager.getSorts().keySet().toArray(new String[0]);
    }

    private void setInitial(VisualizationConfig<?> config) {
        config.setSort(new MergeSort<>());
    }

    private Sort getSort(Class<? extends Sort> sortClass) {
        try {
            return sortClass.getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
