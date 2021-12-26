package myts.victoria.config;

import myts.victoria.sortings.Sort;

import java.util.List;
import java.util.function.BiFunction;

public class VisualizationConfig<T extends Comparable<T>> {
    private List<T> list;
    private int delay;

    private Sort<T> sort;

    private Color backgroundColor;
    private Color mainColor;
    private Color swapColor;
    private Color searchColor;
    private Color mergeColor;
    private int windowSize;

    private BiFunction<T, T, Boolean> compareMatch;

    public void copyFrom(VisualizationConfig<?> config) {
        backgroundColor = config.backgroundColor;
        mainColor = config.mainColor;
        swapColor = config.swapColor;
        searchColor = config.searchColor;
        mergeColor = config.mergeColor;
        windowSize = config.windowSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Sort<T> getSort() {
        return sort;
    }

    public void setSort(Sort<T> sort) {
        this.sort = sort;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    public Color getSwapColor() {
        return swapColor;
    }

    public void setSwapColor(Color swapColor) {
        this.swapColor = swapColor;
    }

    public Color getSearchColor() {
        return searchColor;
    }

    public void setSearchColor(Color searchColor) {
        this.searchColor = searchColor;
    }

    public Color getMergeColor() {
        return mergeColor;
    }

    public void setMergeColor(Color mergeColor) {
        this.mergeColor = mergeColor;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(int windowSize) {
        this.windowSize = windowSize;
    }

    public BiFunction<T, T, Boolean> getCompareMatch() {
        return compareMatch;
    }

    public void setCompareMatch(BiFunction<T, T, Boolean> compareMatch) {
        this.compareMatch = compareMatch;
    }
}
