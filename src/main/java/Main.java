import token.Token;
import token.Tokenizer;
import token.visitors.PrintVisitor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input = "(23 + 10) * 5 - 3 * (32 + 5) * (10 - 4 * 5) + 8 / 2";
        Tokenizer tokenizer = new Tokenizer();
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(tokens);

    }
}
