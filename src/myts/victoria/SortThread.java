package myts.victoria;

import myts.victoria.sortings.Sort;

public class SortThread<T extends Comparable<T>> extends Thread {

    private final Sort<T> sort;

    public SortThread(Sort<T> sort) {
        this.sort = sort;
    }

    @Override
    public void run() {
        try {
            sort.sort();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
