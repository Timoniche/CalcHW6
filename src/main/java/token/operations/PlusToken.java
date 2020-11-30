package token.operations;

import lombok.Getter;
import token.OperationsToken;

public class PlusToken extends OperationsToken {
    private @Getter
    final int priority = 1;

    @Override
    public String toString() {
        return "PLUS";
    }

}
