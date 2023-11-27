package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exp function in the Picasso language.
 * @author Reese Nelson
 */
public class Exp extends UnaryFunction {

	/**
	 * Create an exp expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to raise e to
	 */
	public Exp(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by raising e to
	 * the power of the function's parameter.
	 * 
	 * @return the color from raising e to the expression's parameter
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
