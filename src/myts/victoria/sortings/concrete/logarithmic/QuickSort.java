package myts.victoria.sortings.concrete.logarithmic;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    public QuickSort(VisualizationConfig<T> config) {
        super(config);
    }

    @Override
    public void sort() throws Exception {
        checkVariables();
        quickSort(0, list.size() - 1);
        callback.run(null);
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            callback.run(new RedrawArguments(getAllIndices(left, right), CallbackType.DIVIDING));
            int pi = partition(left, right);

            quickSort(left, pi - 1);
            quickSort(pi + 1, right);
        }
    }

    private List<Integer> getAllIndices(int left, int right) {
        return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
    }

    private int partition(int left, int right) {

        System.out.println(left + " " + right);
        T pivot = list.get(right);

        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (!getCompare().apply(list.get(j), pivot)) {
                i++;
                callback.run(new RedrawArguments(Arrays.asList(i, j), CallbackType.SWAPPING));
                swap(i, j);
            }
        }
        callback.run(new RedrawArguments(Arrays.asList(i + 1, right), CallbackType.SWAPPING));
        swap(i + 1, right);
        return i + 1;
    }

}
