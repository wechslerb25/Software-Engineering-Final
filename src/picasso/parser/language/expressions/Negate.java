/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.CharConstants;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the negate unary operator in the Picasso language.
 * @author Reese Nelson
 */
public class Negate extends UnaryOperator{
	
	String operator = "" + CharConstants.BANG;

	/**
	 * Create a negate operator that takes as a parameter the given expression
	 * 
	 * @param exp the first expression to negate
	 */
	public Negate(ExpressionTreeNode exp) {
		super(exp);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = exp.evaluate(x, y);
		double red = result1.getRed() * -1;
		double green = result1.getGreen() * -1;
		double blue = result1.getBlue() * -1;
		
		return new RGBColor(red, green, blue);
	}

}
