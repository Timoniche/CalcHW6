package calculation;

import org.junit.jupiter.api.Test;
import token.Token;
import token.Tokenizer;
import visitors.CalcVisitor;
import visitors.ParserVisitor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    private final Tokenizer tokenizer = new Tokenizer();
    private final ParserVisitor parserVisitor = new ParserVisitor();
    private final CalcVisitor calcVisitor = new CalcVisitor();

    @Test
    public void testPlus() {
        String input = "( (30 + 2)  ) ";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(32, ans);
    }

    @Test
    public void testMinus() {
        String input = "( (30 - 2)  ) ";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(28, ans);
    }

    @Test
    public void testMul() {
        String input = "( (30 * 2)  ) * 1 * 3 ";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(180, ans);
    }

    @Test
    public void testDiv() {
        String input = "( (30 / 2)  ) / 1 ";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(15, ans);
    }

    @Test
    public void testDiv2() {
        String input = "( (30 / 4)  ) / 1 ";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(7, ans);
    }

    @Test
    public void testPlusDiv() {
        String input = "(30 + 2) / 8";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(4, ans);
    }

    @Test
    public void testFull() {
        String input = "((30 + 2) / 6 - 7) * 3";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        calcVisitor.visit(tokensPolish);
        Integer ans = calcVisitor.calcExpression();
        assertEquals(-6, ans);
    }
}
