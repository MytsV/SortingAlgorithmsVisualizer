package myts.victoria.configapp.elements;

import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;
import myts.victoria.sortings.SortManager;
import myts.victoria.sortings.concrete.logarithmic.MergeSort;

import javax.swing.*;

public class ConfigurationTypesSelection extends JComboBox<String> {

    public ConfigurationTypesSelection(VisualizationConfig<Integer> config, SortManager<Integer> sortManager) {
        super(getSortArray(sortManager));

        setInitial(config);

        addActionListener((event) -> {
            String item = getItemAt(getSelectedIndex());
            Class<? extends Sort<Integer>> klass = sortManager.getSorts().get(item);
            config.setSort(getSort(klass, config));
        });
    }

    private static String[] getSortArray(SortManager<Integer> sortManager) {
        return sortManager.getSorts().keySet().toArray(new String[0]);
    }

    private void setInitial(VisualizationConfig<Integer> config) {
        config.setSort(new MergeSort<>(config));
    }

    private Sort<Integer> getSort(Class<? extends Sort<Integer>> sortClass, VisualizationConfig<Integer> config) {
        try {
            return sortClass.getDeclaredConstructor().newInstance(config);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
