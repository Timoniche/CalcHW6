package visitors;

import token.BracesToken;
import token.NumberToken;
import token.OperationsToken;
import token.Token;
import token.operations.DivToken;
import token.operations.MulToken;
import token.operations.PlusToken;

import java.util.List;
import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    private final Stack<Integer> stack;
    private Integer calculated;

    public CalcVisitor() {
        this.stack = new Stack<Integer>();
        this.calculated = 0;
    }

    public Integer calcExpression() {
        return calculated;
    }

    public void visit(NumberToken token) {
        stack.add(token.getVal());
    }

    public void visit(BracesToken token) throws RuntimeException {
        throw new RuntimeException("There are no brackets in Reverse Polish");
    }

    public void visit(OperationsToken token) {
        assert (stack.size() >= 2) : "Operations(+|-|*|/|) requires two arguments";
        Integer fst = stack.pop();
        Integer snd = stack.pop();
        if (token instanceof DivToken) {
            stack.push(snd / fst);
        } else if (token instanceof MulToken) {
            stack.push(snd * fst);
        } else if (token instanceof PlusToken) {
            stack.push(snd + fst);
        } else {
            stack.push(snd - fst);
        }
    }

    public void visit(List<Token> tokens) {
        for (Token token : tokens) {
            token.accept(this);
        }
        assert (stack.size() == 1) : "Stack size must be equal 1 in the end";
        calculated = stack.pop();
    }
}
