/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operation that takes one expressions as an argument.
 * 
 * @author Reese Nelson
 */
public abstract class UnaryOperator extends ExpressionTreeNode{
	
	ExpressionTreeNode exp;
	
	private String operator = "unop";

	/**
	 * 
	 * @param exp the expression
	 */
	public UnaryOperator(ExpressionTreeNode exp) {
		this.exp = exp;
	}
	
	/**
	 * Returns the string representation of the operation in the format 
	 * "<operator>(<exp>)"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return operator + "(" + exp + ")";
	}
	
	/*
	 * Determines whether a UnaryOperator node is equal to another.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof UnaryOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		UnaryOperator b = (UnaryOperator) o;

		// check if their parameters are equal
		if (!this.exp.equals(b.exp)) {
			return false;
		}
		return true;
	}
}
