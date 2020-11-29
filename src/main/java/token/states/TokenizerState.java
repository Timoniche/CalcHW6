package token.states;

public abstract class TokenizerState {
    public abstract void processTokenChar(char ch) throws UnsupportedOperationException;
    public void actionsEOF() {}
}