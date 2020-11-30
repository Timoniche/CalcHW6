package combined;

import org.junit.jupiter.api.Test;
import token.Token;
import token.Tokenizer;
import visitors.ParserVisitor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenParserTest {
    private final Tokenizer tokenizer = new Tokenizer();
    private final ParserVisitor parserVisitor = new ParserVisitor();

    @Test
    public void testTokenParser() {
        String input = "(30 + 2) / 8";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        assertEquals("[LEFT, NUMBER(30), PLUS, NUMBER(2), RIGHT, DIV, NUMBER(8)]", tokens.toString());
        parserVisitor.visit(tokens);
        ArrayList<Token> tokensPolish = parserVisitor.parseToReversePolish();
        assertEquals("[NUMBER(30), NUMBER(2), PLUS, NUMBER(8), DIV]", tokensPolish.toString());
    }

}
