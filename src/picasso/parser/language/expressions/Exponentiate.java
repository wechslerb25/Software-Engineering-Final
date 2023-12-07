/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.CharConstants;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exponentiate binary operator in the Picasso language.
 * @author Reese Nelson
 */
public class Exponentiate extends BinaryOperator{
	
	String operator = "" + CharConstants.CARET;

	/**
	 * Create an exponentiate expression that takes as a parameter the given expressions
	 * 
	 * @param exp1 the base expression
	 * @param exp2 the power expression
	 */
	public Exponentiate(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
		super(exp1, exp2);
		this.setOpLabel(operator);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = exp1.evaluate(x, y);
		RGBColor result2 = exp2.evaluate(x, y);
		double red = Math.pow(result1.getRed(), result2.getRed());
		double green = Math.pow(result1.getGreen(), result2.getGreen());
		double blue = Math.pow(result1.getBlue(), result2.getBlue());
		
		return new RGBColor(red, green, blue);
	}

}
