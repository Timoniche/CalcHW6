package token.operations;

import lombok.Getter;
import token.OperationsToken;

public class MinusToken extends OperationsToken {
    private @Getter
    final int priority = 1;

    @Override
    public String toString() {
        return "MINUS";
    }

}
