package token;

import java.util.List;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(BracesToken token);
    void visit(OperationsToken token);
    void visit(List<Token> tokens);
}
