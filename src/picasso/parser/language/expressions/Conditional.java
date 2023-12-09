package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the exp function in the Picasso language.
* @author Reese Nelson
*/
public class Conditional extends AbstractFunction{
	
	/**
	 * Create a conditional function that takes as a parameter the given expressions
	 * 
	 * @param cond the condition to evaluate
	 * @param t the expression to evaluate if the condition is true
	 * @param f the expression to evaluate if the condition is false
	 */
	public Conditional(ExpressionTreeNode cond, ExpressionTreeNode t, ExpressionTreeNode f) {
		super(cond, t, f);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor resultCond = params.get(0).evaluate(x, y);
		RGBColor resultT = params.get(1).evaluate(x, y);
		RGBColor resultF = params.get(2).evaluate(x, y);
		
		
		/*double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);*/
		return null;
	}
}
