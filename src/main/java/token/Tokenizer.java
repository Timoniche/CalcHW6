package token;

import token.braces.LeftBraceToken;
import token.braces.RightBraceToken;
import token.operations.DivToken;
import token.operations.MinusToken;
import token.operations.MulToken;
import token.operations.PlusToken;
import token.states.TokenizerState;

import java.util.ArrayList;

import static java.lang.Character.isWhitespace;

public class Tokenizer {
    private ArrayList<Token> tokens;
    private final TokenizerState STATE_CHOICE = new StateChoice();
    private final TokenizerState STATE_VAL = new StateVal();
    private TokenizerState state = STATE_CHOICE;

    private String dropWhitespaces(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (!isWhitespace(ch)) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public ArrayList<Token> tokenize(String input) {
        this.tokens = new ArrayList<Token>();
        input = dropWhitespaces(input);
        state = STATE_CHOICE;
        for (char ch : input.toCharArray()) {
            state.processTokenChar(ch);
        }
        state.actionsEOF();
        return tokens;
    }

    class StateVal extends TokenizerState {
        private int val = 0;

        private NumberToken buildToken() {
            return new NumberToken(val);
        }

        private void reload() {
            val = 0;
        }

        public void actionsEOF() {
            tokens.add(buildToken());
            reload();
            state = STATE_CHOICE;
        }

        public void processTokenChar(char ch) throws UnsupportedOperationException {
            if (Character.isDigit(ch)) {
                int dig = Integer.parseInt(String.valueOf(ch));
                val = val * 10 + dig;
            } else {
                tokens.add(buildToken());
                reload();
                state = STATE_CHOICE;
                state.processTokenChar(ch);
            }

        }
    }


    class StateChoice extends TokenizerState {

        public void processTokenChar(char ch) throws UnsupportedOperationException {
            switch (ch) {
                case '(':
                    tokens.add(new LeftBraceToken());
                    break;
                case ')':
                    tokens.add(new RightBraceToken());
                    break;
                case '+':
                    tokens.add(new PlusToken());
                    break;
                case '-':
                    tokens.add(new MinusToken());
                    break;
                case '*':
                    tokens.add(new MulToken());
                    break;
                case '/':
                    tokens.add(new DivToken());
                    break;
                default:
                    if (Character.isDigit(ch)) {
                        state = STATE_VAL;
                        state.processTokenChar(ch);
                    } else {
                        throw new UnsupportedOperationException("Unknown char");
                    }
                    break;
            }

        }
    }
}
