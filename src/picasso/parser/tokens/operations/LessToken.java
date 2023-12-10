package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the less than symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class LessToken extends CharToken implements OperationInterface {
	public LessToken() {
		super(CharConstants.LESS);
	}
}
