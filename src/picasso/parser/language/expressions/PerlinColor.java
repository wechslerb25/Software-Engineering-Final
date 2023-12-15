package picasso.parser.language.expressions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the perlinColor function in the Picasso language.
* @author Reese Nelson
*/
public class PerlinColor extends AbstractFunction {
	
	/**
	 * Create a perlinColor function that takes as a parameter the given expressions
	 * 
	 * @param exp1 the first expression
	 * @param exp2 the second expression
	 */
	public PerlinColor(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = params.get(0).evaluate(x, y);
		RGBColor result2 = params.get(1).evaluate(x, y);
		
		double red = ImprovedNoise.noise(result1.getRed() + 0.3, result2.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(result1.getBlue() + 0.1, result2.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(result1.getGreen() - 0.8, result2.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}
}
