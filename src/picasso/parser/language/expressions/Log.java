package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Log extends Function {
	
	public Log(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		double red = Math.log(result.getRed());
		double green = Math.log(result.getGreen());
		double blue = Math.log(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
