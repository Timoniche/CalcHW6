import token.Token;
import token.Tokenizer;
import visitors.CalcVisitor;
import visitors.ParserVisitor;
import visitors.PrintVisitor;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String input = "(23 + 10) * 5 - 3 * (32 + 5) * (10 - 4 * 5) + 8 / 2";
        // String input = "(2 + 3)";
        // String input = "(30 + 2) / 8";
        System.out.println(input);

        Tokenizer tokenizer = new Tokenizer();
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(tokens);

        ParserVisitor parserVisitor = new ParserVisitor();
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        printVisitor.visit(tokensPolish);

        CalcVisitor calcVisitor = new CalcVisitor();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        System.out.println(ans);
    }
}
