/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents an operation that takes one or more expressions as arguments.
 * 
 * @author Reese Nelson
 */
public abstract class AbstractOperator extends ExpressionTreeNode{
	
	ExpressionTreeNode exp1;
	ExpressionTreeNode exp2;
	private String operator;

	/**
	 * 
	 * @param exp1 the first expression
	 * @param exp2 the second expression
	 */
	public AbstractOperator(ExpressionTreeNode exp1, ExpressionTreeNode exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
		this.operator = "binop";
	}
	
	public void setOpLabel(String label) {
		this.operator = label;
	}
	
	/**
	 * Returns the string representation of the operation in the format 
	 * "<exp1> <operator> <exp2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return exp1 + " " + operator + " " + exp2;
	}
	
	/*
	 * Determines whether a BinaryOperator node is equal to another.
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof AbstractOperator)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		AbstractOperator b = (AbstractOperator) o;

		// check if their parameters are equal
		if (!this.exp1.equals(b.exp1) || !this.exp2.equals(b.exp2)) {
			return false;
		}
		return true;
	}
}
