package picasso.parser.tokens;

import picasso.model.Pixmap;

public class StringToken extends Token {
    private String data;
    private Pixmap pixmap;

    public StringToken(String data) {
        super("String Token");
        this.data = data;
        this.pixmap = new Pixmap(data);
        System.out.println(this.data);
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
