package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the negate token, or "bang" token.
 * 
 * @author Reese Nelson
 */
public class BangToken extends CharToken implements OperationInterface {
	public BangToken() {
		super(CharConstants.BANG);
	}
}
