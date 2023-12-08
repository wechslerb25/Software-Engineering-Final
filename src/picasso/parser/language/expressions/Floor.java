package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the exp function in the Picasso language.
 * @author AJ Thomas
 */
public class Floor extends AbstractFunction {

	/**
	 * Create an floor expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to floor
	 */
	public Floor(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the floor of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the floor of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		double red = Math.floor(result.getRed());
		double green = Math.floor(result.getGreen());
		double blue = Math.floor(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
