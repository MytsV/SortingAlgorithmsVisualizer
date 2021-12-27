package myts.victoria.sortings.concrete.logarithmic;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    public HeapSort(VisualizationConfig<T> config) {
        super(config);
    }

    @Override
    public void sort() throws Exception {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            callback.run(new RedrawArguments(Arrays.asList(0, i), CallbackType.SWAPPING));
            swap(0, i);
            heapify(i, 0);
        }

        callback.run(null);
    }

    private List<Integer> getAllIndices(int left, int right) {
        return IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
    }

    void heapify(int n, int i)
    {
        callback.run(new RedrawArguments(getAllIndices(i, i + n - 1), CallbackType.DIVIDING));
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && getCompare().apply(list.get(l), list.get(largest)))
            largest = l;

        if (r < n && getCompare().apply(list.get(r), list.get(largest)))
            largest = r;

        if (largest != i) {
            callback.run(new RedrawArguments(Arrays.asList(i, largest), CallbackType.SWAPPING));
            swap(i, largest);
            heapify(n, largest);
        }
    }
}
