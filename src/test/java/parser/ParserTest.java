package parser;

import org.junit.jupiter.api.Test;
import token.NumberToken;
import token.Token;
import token.Tokenizer;
import token.operations.DivToken;
import token.operations.MulToken;
import token.operations.PlusToken;
import visitors.ParserVisitor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    private final Tokenizer tokenizer = new Tokenizer();
    private final ParserVisitor parserVisitor = new ParserVisitor();

    @Test
    public void testParserSimple() {
        String input = "(2 + 3) * 6";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        ArrayList<Token> arr = new ArrayList<Token>();
        arr.add(new NumberToken(2));
        arr.add(new NumberToken(3));
        arr.add(new PlusToken());
        arr.add(new NumberToken(6));
        arr.add(new MulToken());
        assertEquals(arr.toString(), tokensPolish.toString());
    }

    @Test
    public void testParserFromReadme() {
        String input = "(30 + 2) / 8";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        assertEquals("[NUMBER(30), NUMBER(2), PLUS, NUMBER(8), DIV]", tokensPolish.toString());
    }

}
