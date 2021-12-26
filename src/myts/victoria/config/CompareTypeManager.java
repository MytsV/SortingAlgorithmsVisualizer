package myts.victoria.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CompareTypeManager<T extends Comparable<T>> {

    private final Map<String, BiFunction<T, T, Boolean>> compareTypes;

    public CompareTypeManager() {
        compareTypes = new HashMap<>();
        compareTypes.put("Ascending", (a, b) -> a.compareTo(b) >= 0);
        compareTypes.put("Descending", (a, b) -> a.compareTo(b) <= 0);
    }

    public Map<String, BiFunction<T, T, Boolean>> getCompareTypes() {
        return compareTypes;
    }

}
