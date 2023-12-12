package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the "or" symbol in the Picasso programming language
 * 
 * @author Reese Nelson
 */
public class OrToken extends CharToken implements OperationInterface {
	public OrToken() {
		super(CharConstants.OR);
	}
}
