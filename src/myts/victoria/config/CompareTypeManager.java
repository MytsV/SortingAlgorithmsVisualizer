package myts.victoria.config;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CompareTypeManager {

    private static CompareTypeManager instance;

    private final Map<String, BiFunction<? extends Comparable, ? extends Comparable, Boolean>> compareTypes;

    private CompareTypeManager() {
        compareTypes = new HashMap<>();
        compareTypes.put("Ascending", (a, b) -> a.compareTo(b) >= 0);
        compareTypes.put("Descending", (a, b) -> a.compareTo(b) <= 0);
    }

    public static CompareTypeManager getInstance() {
        if (instance == null) {
            instance = new CompareTypeManager();
        }
        return instance;
    }

    public Map<String, BiFunction<? extends Comparable, ? extends Comparable, Boolean>> getCompareTypes() {
        return compareTypes;
    }

}
