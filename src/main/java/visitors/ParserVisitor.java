package visitors;

import token.BracesToken;
import token.NumberToken;
import token.OperationsToken;
import token.Token;
import token.braces.LeftBraceToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    private final Stack<Token> stack;
    private final ArrayList<Token> reversePolishList;

    public ParserVisitor() {
        this.stack = new Stack<Token>();
        this.reversePolishList = new ArrayList<Token>();
    }

    public ArrayList<Token> parseToReversePolish() {
        return reversePolishList;
    }

    public void visit(NumberToken token) {
        reversePolishList.add(token);
    }

    public void visit(BracesToken token) throws RuntimeException {
        if (token instanceof LeftBraceToken) {
            stack.push(token);
        } else {
            while (!stack.empty()) {
                Token elem = stack.peek();
                if (elem instanceof LeftBraceToken) {
                    stack.pop();
                    break;
                } else if (elem instanceof OperationsToken) {
                    stack.pop();
                    reversePolishList.add(elem);
                } else {
                    printStack();
                    throw new RuntimeException("Stack is not consistent");
                }
            }
        }
    }

    public void visit(OperationsToken token) {
        while (!stack.empty()) {
            Token elem = stack.peek();
            if (elem instanceof OperationsToken && token.getPriority() <= ((OperationsToken) elem).getPriority()) {
                stack.pop();
                reversePolishList.add(elem);
            } else {
                break;
            }
        }
        stack.push(token);
    }

    public void visit(List<Token> tokens) {
        for (Token token : tokens) {
            token.accept(this);
        }
        dumpOperationStack();
    }

    private void dumpOperationStack() throws RuntimeException {
        while (!stack.empty()) {
            Token elem = stack.peek();
            if (elem instanceof OperationsToken) {
                stack.pop();
                reversePolishList.add(elem);
            } else {
                printStack();
                throw new RuntimeException("Stack is not consistent (RIGHT BRACE missed)");
            }
        }
    }

    private void printStack() {
        for (Token e : stack) {
            System.out.print(e.toString() + " ");
        }
        System.out.println();
    }
}
