package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the RgbToYCrCb function in the Picasso language.
* @author Reese Nelson
*/
public class RgbToYCrCb extends AbstractFunction {
	
	public RgbToYCrCb(ExpressionTreeNode param) {
		super(param);
	
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		
		double red = result.getRed() * 0.2989 + result.getGreen() * 0.5866 + result.getBlue() * 0.1145;
		double green = result.getRed() * -0.1687 + result.getGreen() * -0.3312 + result.getBlue() * 0.5;
		double blue = result.getRed() * 0.5000 + result.getGreen() * -0.4183 + result.getBlue() * -0.0816;
		return new RGBColor(red, green, blue);
	}
}