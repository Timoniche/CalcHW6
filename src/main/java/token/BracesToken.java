package token;

public class BracesToken implements Token {
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
