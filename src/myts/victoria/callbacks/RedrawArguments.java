package myts.victoria.callbacks;

import java.util.List;

public class RedrawArguments {
    private final List<Integer> changeIndices;
    private final CallbackType callbackType;

    public RedrawArguments(List<Integer> changeIndices, CallbackType callbackType) {
        this.changeIndices = changeIndices;
        this.callbackType = callbackType;
    }

    public CallbackType getCallbackType() {
        return callbackType;
    }

    public List<Integer> getChangeIndices() {
        return changeIndices;
    }
}