package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one argument.
 * 
 * @author Reese Nelson
 */
public abstract class TernaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode cond;
	ExpressionTreeNode t;
	ExpressionTreeNode f;

	/**
	 * 
	 * @param param
	 */
	public TernaryFunction(ExpressionTreeNode cond, ExpressionTreeNode t, ExpressionTreeNode f) {
		this.cond = cond;
		this.t = t;
		this.f = f;
	}

	/**
	 * Returns the string representation of the function in the format 
	 * "<ClassName>(<parameter>)"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".") + 1).toLowerCase() + "(" + cond + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof TernaryFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		TernaryFunction tf = (TernaryFunction) o;

		// check if their parameters are equal
		if (!this.cond.equals(tf.cond) && !this.t.equals(tf.t) && !this.f.equals(tf.f)) {
			return false;
		}
		return true;
	}

}
