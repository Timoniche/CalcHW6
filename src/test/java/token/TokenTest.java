package token;

import org.junit.jupiter.api.Test;
import token.braces.LeftBraceToken;
import token.braces.RightBraceToken;
import token.operations.DivToken;
import token.operations.MinusToken;
import token.operations.MulToken;
import token.operations.PlusToken;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TokenTest {
    private final Tokenizer tokenizer = new Tokenizer();

    @Test
    public void testTokenizerVal() {
        String input = "23";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        ArrayList<Token> arr = new ArrayList<Token>();
        arr.add(new NumberToken(23));
        assertEquals(arr.toString(), tokens.toString());
    }

    @Test
    public void testTokenizerMinus() {
        String input = "-";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        ArrayList<Token> arr = new ArrayList<Token>();
        arr.add(new MinusToken());
        assertEquals(arr.toString(), tokens.toString());
    }

    @Test
    public void testTokenizerPlus() {
        String input = "+";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        ArrayList<Token> arr = new ArrayList<Token>();
        arr.add(new PlusToken());
        assertEquals(arr.toString(), tokens.toString());
    }

    @Test
    public void testTokenizerArbitrary() {
        String input = "28 * 37 - (5 / 2)";
        ArrayList<Token> tokens = tokenizer.tokenize(input);
        ArrayList<Token> arr = new ArrayList<Token>();
        arr.add(new NumberToken(28));
        arr.add(new MulToken());
        arr.add(new NumberToken(37));
        arr.add(new MinusToken());
        arr.add(new LeftBraceToken());
        arr.add(new NumberToken(5));
        arr.add(new DivToken());
        arr.add(new NumberToken(2));
        arr.add(new RightBraceToken());
        assertEquals(arr.toString(), tokens.toString());
    }
}
