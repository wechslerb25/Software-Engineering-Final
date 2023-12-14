package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the greater than or equal to symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class GreaterEqualsToken extends CharToken implements OperationInterface {
	public GreaterEqualsToken() {
		super(CharConstants.GREATER_EQUALS);
	}
}
