package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class RgbToYCrCb extends AbstractFunction {
	
	public RgbToYCrCb(ExpressionTreeNode param) {
		super(param);
	
	}
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = params.get(0).evaluate(x, y);
		
		double yValue = 0.299 * result.getRed() + 0.587 * result.getGreen() + 0.114 * result.getBlue();
		double cbValue = -0.169 * result.getRed() - 0.331 * result.getGreen() + 0.5 * result.getBlue();
		double crValue = 0.5 * result.getRed() - 0.419 * result.getGreen() - 0.081 * result.getBlue();
		
		yValue = clamp(yValue, -1.0, 1.0);
        cbValue = clamp(cbValue, -1.0, 1.0);
        crValue = clamp(crValue, -1.0, 1.0);

        return new RGBColor(yValue, cbValue, crValue);
		
		
		
	}
	private double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
	}
}