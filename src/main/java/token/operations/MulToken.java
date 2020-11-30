package token.operations;

import lombok.Getter;
import token.OperationsToken;

public class MulToken extends OperationsToken {
    private @Getter
    final int priority = 2;

    @Override
    public String toString() {
        return "MUL";
    }

}
