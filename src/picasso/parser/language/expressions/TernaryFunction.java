package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one argument.
 * 
 * @author Reese Nelson
 */
public abstract class TernaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode param1;
	ExpressionTreeNode param2;
	ExpressionTreeNode param3;

	/**
	 * 
	 * @param param
	 */
	public TernaryFunction(ExpressionTreeNode param1, ExpressionTreeNode param2, ExpressionTreeNode param3) {
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}

	/**
	 * Returns the string representation of the function in the format 
	 * "<ClassName>(<parameter1>, <parameter2>, <parameter3>)"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".") + 1).toLowerCase() + "(" + param1 + ", " + param2 + ", " + param3 + ")";
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
		if (!this.param1.equals(tf.param1) && !this.param2.equals(tf.param2) && !this.param3.equals(tf.param3)) {
			return false;
		}
		return true;
	}

}
