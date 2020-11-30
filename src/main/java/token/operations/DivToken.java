package token.operations;

import token.OperationsToken;

public class DivToken extends OperationsToken {
    private final int priority = 2;

    @Override
    public String toString() {
        return "DIV";
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
