package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the multiplication sign token, or "star" token.
 * 
 * @author Reese Nelson
 */
public class StarToken extends CharToken implements OperationInterface {
	public StarToken() {
		super(CharConstants.STAR);
	}
}
