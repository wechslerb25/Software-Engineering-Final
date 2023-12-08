package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Increment extends Function {

	public Increment(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		double red = result.getRed() + 1;
		double green = result.getGreen() + 1;
		double blue = result.getBlue() + 1;

		return new RGBColor(red, green, blue);
	}

}