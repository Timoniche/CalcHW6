package token.operations;

import token.OperationsToken;

public class PlusToken extends OperationsToken {
    private final int priority = 1;

    @Override
    public String toString() {
        return "PLUS";
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
