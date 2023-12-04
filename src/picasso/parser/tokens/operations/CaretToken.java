package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the exponentiate token, or "caret" token.
 * 
 * @author Reese Nelson
 */
public class CaretToken extends CharToken implements OperationInterface {
	public CaretToken() {
		super(CharConstants.CARET);
	}
}
