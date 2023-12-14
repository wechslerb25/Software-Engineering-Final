/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.ParseException;
import picasso.parser.language.CharConstants;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the "and" comparison.
 * @author Reese Nelson
 */
public class And extends AbstractOperator{
	
	String operator = "" + CharConstants.AND;

	/**
	 * Create an "and" expression that takes as a parameter the given expressions
	 * 
	 * @param exp1 the left expression
	 * @param exp2 the right expression
	 */
	public And(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
		super(exp1, exp2);
		this.setOpLabel(operator);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = exp1.evaluate(x, y);
		RGBColor result2 = exp2.evaluate(x, y);
		//for comparisons, all color vals should be the same.
		double error = 0.001;
		if ((Math.abs(result1.getBlue() - result1.getGreen()) > error) || (Math.abs(result1.getGreen() - result1.getRed()) > error)) {
			throw new ParseException("Invalid Comparison. Comparison failed as compared values are not grayscale.");
		}
		else if ((Math.abs(result2.getBlue() - result2.getGreen()) > error) || (Math.abs(result2.getGreen() - result2.getRed()) > error)) {
			throw new ParseException("Invalid Comparison. Comparison failed as compared values are not grayscale.");
		}
		double val1 = result1.getRed();
		double val2 = result2.getRed();
		//must be -1 or 1
		if(Math.abs(Math.abs(val1) - 1) > error || Math.abs(Math.abs(val2) - 1) > error) {
			throw new ParseException("Invalid Comparison. Comparison failed as compared values are not -1 or 1.");
		}

		//true represented by [1,1,1]. false represented by [-1,-1,-1].
		if ((Math.abs(val1 - 1) < error) && (Math.abs(val2 - 1) < error)) {
			return new RGBColor(1,1,1);
		}
		else {
			return new RGBColor(-1,-1,-1);
		}		
	}
}
