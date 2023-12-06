package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

public class Conditional extends TernaryFunction{

	public Conditional(ExpressionTreeNode cond, ExpressionTreeNode t, ExpressionTreeNode f) {
		super(cond, t, f);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// TODO Auto-generated method stub
		return null;
	}

}
