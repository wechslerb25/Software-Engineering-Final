package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Tan function in the Picasso language.
 * 
 * @author Janeet Bajracharya
 * 
 */
public class Tan extends UnaryFunction {

	/**
	 * Create a Tan expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Tan(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the tan of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the tan of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.tan(result.getRed());
		double green = Math.tan(result.getGreen());
		double blue = Math.tan(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}