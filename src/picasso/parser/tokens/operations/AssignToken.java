package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the equals sign for assignments in the Picasso programming language
 */
public class AssignToken extends CharToken {
	public AssignToken() {
		super(CharConstants.EQUAL);
	}
}
