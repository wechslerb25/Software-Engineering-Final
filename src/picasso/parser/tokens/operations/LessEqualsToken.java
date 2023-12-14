package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the less than or equal to symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class LessEqualsToken extends CharToken implements OperationInterface {
	public LessEqualsToken() {
		super(CharConstants.LESS_EQUALS);
	}
}
