package token;

public class OperationsToken implements Token {

    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
