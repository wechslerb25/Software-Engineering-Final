package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Wrap extends AbstractFunction {
	
	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		double red = result.getRed();
		if (red>1.0) {
			red = red-2;
		}
		if (red<-1.0) {
			red = red+2;
		}
		double green = result.getGreen();
		if (green>1.0) {
			green = green-2;
		}
		if (green<-1.0) {
			green = green+2;
		}
		double blue = result.getBlue();
		if (blue>1.0) {
			blue = blue-2;
		}
		if (blue<-1.0) {
			blue = blue+2;
		}
		return new RGBColor(red, green, blue);
	}
}
