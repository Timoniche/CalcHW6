package token;

import visitors.TokenVisitor;

public abstract class OperationsToken implements Token {
    public abstract int getPriority();
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
