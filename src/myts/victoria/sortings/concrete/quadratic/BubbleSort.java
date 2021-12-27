package myts.victoria.sortings.concrete.quadratic;

import myts.victoria.callbacks.CallbackType;
import myts.victoria.callbacks.RedrawArguments;
import myts.victoria.config.VisualizationConfig;
import myts.victoria.sortings.Sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    public BubbleSort(VisualizationConfig<T> config) {
        super(config);
    }

    public void sort() {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                runCallback(j, CallbackType.SEARCHING);
                if (getCompare().apply(list.get(j), list.get(j + 1))) {
                    runCallback(j, CallbackType.SWAPPING);
                    swap(j, j + 1);
                    runCallback(j, CallbackType.SWAPPING);
                }
            }
        }
        callback.run(null);
    }

    private void runCallback(int j, CallbackType type) {
        callback.run(new RedrawArguments(getSwapList(j), type));
    }

    private List<Integer> getSwapList(int j) {
        return Arrays.asList(j, j + 1);
    }

}
