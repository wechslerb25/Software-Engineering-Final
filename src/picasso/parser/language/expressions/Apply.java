package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Apply extends AbstractFunction{

	/**
	 * Create an Apply expression that takes as a parameter the given expressions
	 * 
	 * @param exp1 the image at t-1.
	 * @param exp2 the logic to apply to the image at t 
	 */
	public Apply(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
		super(exp1, exp2);
	}
    
    @Override
    public RGBColor evaluate(double x, double y) {
        
    }


    
}
