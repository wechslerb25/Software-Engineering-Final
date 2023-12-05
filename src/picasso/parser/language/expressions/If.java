package picasso.parser.language.ressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the if function in the Picasso language.
 * @author Reese Nelson
 */
public class If extends UnaryFunction {

	/**
	 * Create an if expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to raise e to
	 */
	public If(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by
     * applying the if condition in the analyser and the evaluate just finalizing the value.
	 * @return the color from if condition that was passed in as x.
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
