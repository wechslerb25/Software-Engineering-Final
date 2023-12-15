package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class YCrCbToRGB extends AbstractFunction {
	
	public YCrCbToRGB(ExpressionTreeNode param) {
		super(param);
	
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		
		double yValue = result.getRed();
        double cbValue = result.getGreen();
        double crValue = result.getBlue();
		
        double red = yValue + 1.402 * (crValue - 128) / 128.0;
        double green = yValue - 0.344136 * (cbValue - 128) / 128.0 - 0.714136 * (crValue - 128) / 128.0;
        double blue = yValue + 1.772 * (cbValue - 128) / 128.0;
        
        red = clamp(red, -1.0, 1.0);
        green = clamp(green, -1.0, 1.0);
        blue = clamp(blue, -1.0, 1.0);

        return new RGBColor(yValue, cbValue, crValue);
		
		
		
	}
	private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
	}
}