package token.visitors;

import token.*;

import java.util.List;

public class PrintVisitor implements TokenVisitor {
    private final String BLANK = " ";

    public void visit(NumberToken token) {
        System.out.print(token.toString());
    }

    public void visit(BracesToken token) {
        System.out.print(token.toString());
    }

    public void visit(OperationsToken token) {
        System.out.print(token.toString());
    }

    public void visit(List<Token> tokens) {
        for (Token token : tokens) {
            token.accept(this);
            System.out.print(BLANK);
        }
        System.out.println();
    }
}
