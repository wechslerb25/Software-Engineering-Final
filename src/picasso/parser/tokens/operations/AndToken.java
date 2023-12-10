package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the "and" symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class AndToken extends CharToken implements OperationInterface {
	public AndToken() {
		super(CharConstants.AND);
	}
}
