package myts.victoria.sortings.concrete.quadratic;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.callbacks.SortCallback;
import myts.victoria.sortings.Sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

    public SelectionSort() {

    }

    public SelectionSort(List<T> list, SortCallback callback) {
        super(list, callback);
    }

    public void sort() {
        for (var i = 0; i < list.size() - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < list.size(); j++) {
                if (!getCompare().apply(list.get(j), list.get(minIndex))) {
                    minIndex = j;
                }
                callback.run(new RedrawArguments(Arrays.asList(i, j), CallbackType.SEARCHING));
            }
            if (minIndex != i) {
                callback.run(new RedrawArguments(Arrays.asList(i, minIndex), CallbackType.SWAPPING));
                swap(minIndex, i);
                callback.run(new RedrawArguments(Arrays.asList(i, minIndex), CallbackType.SWAPPING));
            }
        }
        callback.run(null);
    }

}
