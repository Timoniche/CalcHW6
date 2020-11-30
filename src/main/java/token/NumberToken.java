package token;

import visitors.TokenVisitor;

public class NumberToken implements Token {
    private final int val;

    public NumberToken(int val) {
        this.val = val;
    }

    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public int getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "NUMBER(" + String.valueOf(val) + ")";
    }

}
