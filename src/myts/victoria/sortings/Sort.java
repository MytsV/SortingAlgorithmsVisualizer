package myts.victoria.sortings;

import myts.victoria.callbacks.SortCallback;
import myts.victoria.config.VisualizationConfig;

import java.util.List;
import java.util.function.BiFunction;

public abstract class Sort<T extends Comparable<T>> {

    protected List<T> list;
    protected SortCallback callback;
    private VisualizationConfig<T> config;

    public Sort(VisualizationConfig<T> config) {
        this.config = config;
    }

    public Sort(List<T> list, SortCallback callback) {
        this.list = list;
        this.callback = callback;
    }

    protected BiFunction<T, T, Boolean> getCompare() {
        return config.getCompareMatch();
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public void setCallback(SortCallback callback) {
        this.callback = callback;
    }

    protected void checkVariables() throws Exception {
        if (list == null || callback == null) {
            throw new Exception();
        }
    }

    protected void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public abstract void sort() throws Exception;

}
