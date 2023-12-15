package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the perlinBW function in the Picasso language.
* @author Reese Nelson
*/
public class PerlinBW extends AbstractFunction {
	
	/**
	 * Create a perlinBW function that takes as a parameter the given expressions
	 * 
	 * @param exp1 the first expression
	 * @param exp2 the second expression
	 */
	public PerlinBW(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = params.get(0).evaluate(x, y);
		RGBColor result2 = params.get(1).evaluate(x, y);
		
		double grey = ImprovedNoise.noise(result1.getRed() + result2.getRed(), result1.getGreen() + result2.getGreen(),
				result1.getBlue() + result2.getBlue());
		return new RGBColor(grey, grey, grey);
	}
}
