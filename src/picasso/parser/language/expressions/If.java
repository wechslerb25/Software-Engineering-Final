package picasso.parser.language.expressions;

import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;

/**
* Represents the if function in the Picasso language.
* @author Reese Nelson
*/
public class If extends AbstractFunction{
	
	/**
	 * Create an if function that takes as a parameter the given expressions
	 * 
	 * @param cond the condition to evaluate
	 * @param t the expression to evaluate if the condition is true
	 * @param f the expression to evaluate if the condition is false
	 */
	public If(ExpressionTreeNode cond, ExpressionTreeNode t, ExpressionTreeNode f) {
		super(cond, t, f);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor resultCond = params.get(0).evaluate(x, y);
		RGBColor resultT = params.get(1).evaluate(x, y);
		RGBColor resultF = params.get(2).evaluate(x, y);
		
		//for comparisons, all color vals should be the same.
		double error = 0.001;
		if ((Math.abs(resultCond.getBlue() - resultCond.getGreen()) > error) || (Math.abs(resultCond.getGreen() - resultCond.getRed()) > error)) {
			throw new ParseException("Invalid Comparison. Comparison failed as compared values are not grayscale.");
		}
		double val = resultCond.getRed();
		
		//true case
		if (Math.abs(val - 1) < error) {
			return resultT;
		}
		else {
			return resultF;
		}
	}
}
