package visitors;

import token.BracesToken;
import token.NumberToken;
import token.OperationsToken;
import token.Token;

import java.util.List;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(BracesToken token);
    void visit(OperationsToken token);
    void visit(List<Token> tokens);
}
