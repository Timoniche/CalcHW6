package token.operations;

import token.OperationsToken;

public class MulToken extends OperationsToken {
    private final int priority = 2;

    @Override
    public String toString() {
        return "MUL";
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
