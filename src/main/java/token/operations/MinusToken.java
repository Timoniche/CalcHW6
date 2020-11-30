package token.operations;

import token.OperationsToken;

public class MinusToken extends OperationsToken {
    private final int priority = 1;

    @Override
    public String toString() {
        return "MINUS";
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
