package myts.victoria.sortings;

import myts.victoria.sortings.concrete.logarithmic.MergeSort;
import myts.victoria.sortings.concrete.quadratic.BubbleSort;
import myts.victoria.sortings.concrete.quadratic.SelectionSort;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortManager<T extends Comparable<T>> {

    //regex for transforming class name
    final String titleCaseSplitRegex = "(?<=[a-z])(?=[A-Z])";

    private final Map<String, Class<? extends Sort<T>>> sorts = new LinkedHashMap<>();

    public SortManager() {
        initiateSorts();
    }

    public Map<String, Class<? extends Sort<T>>> getSorts() {
        return sorts;
    }

    private void initiateSorts() {
        var list = Arrays.asList(MergeSort.class, BubbleSort.class, SelectionSort.class);

        for (var element : list) {
            sorts.put(getName(element), (Class<? extends Sort<T>>) element);
        }

    }

    private String getName(Class<?> sortClass) {
        return Arrays.stream(sortClass.getSimpleName().split(titleCaseSplitRegex)).reduce((a, b) -> a + " " + b).orElse("");
    }

}
