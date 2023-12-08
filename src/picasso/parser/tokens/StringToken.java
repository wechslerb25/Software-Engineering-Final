package picasso.parser.tokens;

public class StringToken extends Token {
    private String data;

    public StringToken(String data) {
        super("String Token");
        this.data = data;
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public boolean isFunction() {
        return false;
    }

    public String getValue() {
        return this.data;
    }
}
