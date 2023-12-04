package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the division sign token, or "slash" token.
 * 
 * @author Reese Nelson
 */
public class SlashToken extends CharToken implements OperationInterface {
	public SlashToken() {
		super(CharConstants.SLASH);
	}
}
