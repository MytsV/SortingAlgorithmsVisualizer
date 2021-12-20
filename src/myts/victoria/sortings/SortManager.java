package myts.victoria.sortings;

import myts.victoria.sortings.concrete.logarithmic.MergeSort;
import myts.victoria.sortings.concrete.quadratic.BubbleSort;
import myts.victoria.sortings.concrete.quadratic.SelectionSort;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortManager {

    private final Map<String, Class<? extends Sort>> sorts = new LinkedHashMap<>();

    public SortManager() {
        initiateSorts();
    }

    public Map<String, Class<? extends Sort>> getSorts() {
        return sorts;
    }

    private void initiateSorts() {

        var list = Arrays.asList(MergeSort.class, BubbleSort.class, SelectionSort.class);

        for (var element : list) {
            sorts.put(getName(element), element);
        }

    }

    private String getName(Class<?> sortClass) {
        return sortClass.getSimpleName();
    }

}
