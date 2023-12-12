package picasso.parser;

import picasso.util.ErrorWindow;

/**
 * Describe an exception that occurred during parsing.
 * 
 * @author Sara Sprenkle
 *
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

	public ParseException(String message) {
		super("ParseException: " + message);
		
		ErrorWindow.showErrorPopup(message);
	}

}
