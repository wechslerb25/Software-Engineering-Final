/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operation that takes two arguments.
 * 
 * @author Reese Nelson
 */
public abstract class BinaryOperator extends ExpressionTreeNode{
	
	ExpressionTreeNode param1;
	ExpressionTreeNode param2;

	/**
	 * 
	 * @param param1
	 * @param param2
	 */
	public BinaryOperator(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
	}
	
	/**
	 * Returns the string representation of the operation in the format 
	 * "<ClassName>: <parameter1>, <parameter2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".") + 1) + ": " + param1 + ", " + param2;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof BinaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		BinaryOperator b = (BinaryOperator) o;

		// check if their parameters are equal
		if (!this.param1.equals(b.param1) || !this.param2.equals(b.param2)) {
			return false;
		}
		return true;
	}
}
