/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.CharConstants;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the subtraction binary operator in the Picasso language.
 * @author Reese Nelson
 */
public class Subtraction extends AbstractOperator{
	
		String operator = "" + CharConstants.MINUS;

	/**
	 * Create a subtraction expression that takes as a parameter the given expressions
	 * 
	 * @param exp1 the first expression to subtract
	 * @param exp2 the second expression to subtract
	 */
	public Subtraction(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
		super(exp1, exp2);
		this.setOpLabel(operator);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = exp1.evaluate(x, y);
		RGBColor result2 = exp2.evaluate(x, y);
		double red = result1.getRed() - result2.getRed();
		double green = result1.getGreen() - result2.getGreen();
		double blue = result1.getBlue() - result2.getBlue();
		
		return new RGBColor(red, green, blue);
	}

}
