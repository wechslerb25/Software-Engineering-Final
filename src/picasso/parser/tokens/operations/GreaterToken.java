package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the greater than symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class GreaterToken extends CharToken implements OperationInterface {
	public GreaterToken() {
		super(CharConstants.GREATER);
	}
}
