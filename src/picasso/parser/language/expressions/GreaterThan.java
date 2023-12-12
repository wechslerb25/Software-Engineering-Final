/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.ParseException;
import picasso.parser.language.CharConstants;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the greater than comparison.
 * @author Reese Nelson
 */
public class GreaterThan extends AbstractOperator{
	
	String operator = "" + CharConstants.GREATER;

	/**
	 * Create a greater than expression that takes as a parameter the given expressions
	 * 
	 * @param exp1 the left expression
	 * @param exp2 the right expression
	 */
	public GreaterThan(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
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

		//true represented by [1,1,1]. false represented by [-1,-1,-1].
		if (val1 > val2) {
			return new RGBColor(-1,-1,-1);
		}
		//checks equals case b/c double comparison will not get it.
		else if (Math.abs(val1 - val2) < error) {
			return new RGBColor(-1,-1,-1);
		}
		else {
			return new RGBColor(1,1,1);
		}
	}

}
