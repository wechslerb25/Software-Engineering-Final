package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Clamp extends AbstractFunction {
	
	public Clamp(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		double red = result.getRed();
		if (red>1.0) {
			red = 1.0;
		}
		if (red < -1.0) {
			red = -1.0;
		}
		double green = result.getGreen();
		if (green > 1.0) {
			green = 1.0;
		}
		if (green < -1.0) {
			green = -1.0;
		}
		double blue = result.getBlue();
		if (blue > 1.0) {
			blue = 1.0;
		}
		if (blue < -1.0) {
			blue = -1.0;
		}

		return new RGBColor(red, green, blue);
	}
	
}