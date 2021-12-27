package myts.victoria.sortings.concrete.logarithmic;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    public MergeSort(VisualizationConfig<T> config) {
        super(config);
    }

    public void sort() throws Exception {
        checkVariables();
        mergeSort(0, list.size() - 1);
        callback.run(null);
    }

    private void mergeSort(int left, int right) {
        if (right <= left) return;
        callback.run(new RedrawArguments(getAllIndices(left, right), CallbackType.DIVIDING));
        int middle = (right + left) / 2;
        mergeSort(left, middle);
        mergeSort(middle + 1, right);
        merge(left, right);
    }

    private List<Integer> getAllIndices(int left, int right) {
        return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
    }

    private void merge(int left, int right) {
        List<T> temp = initTemp(right - left);
        setTemp(temp, left, right);

        int idx = left;
        for (T value : temp) {
            callback.run(new RedrawArguments(List.of(idx), CallbackType.SWAPPING));
            list.set(idx++, value);
        }
    }

    private List<T> initTemp(int length) {
        List<T> temp = new ArrayList<>();
        for (int i = 0; i < length + 1; i++) {
            temp.add(null);
        }
        return temp;
    }

    private void setTemp(List<T> temp, int left, int right) {
        int middle = (left + right) / 2;

        int i = left;
        int j = middle + 1;

        for (int k = 0; (i <= middle) || (j <= right); k++) {
            callback.run(new RedrawArguments(Arrays.asList(i, j), CallbackType.SEARCHING));
            if (i > middle) {
                temp.set(k, list.get(j++));
            } else if (j > right) {
                temp.set(k, list.get(i++));
            } else if (getCompare().apply(list.get(j), list.get(i))) {
                temp.set(k, list.get(i++));
            } else {
                temp.set(k, list.get(j++));
            }
        }
    }

}
