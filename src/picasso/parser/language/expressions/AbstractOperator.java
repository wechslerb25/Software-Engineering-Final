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
	 * Creates an operator.
	 * @param exp the expression
	 */
	public AbstractOperator(ExpressionTreeNode exp) {
		this.exp1 = exp;
		this.operator = "unop";
	}
	/**
	 * Creates an operator.
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
	 * "<exp1> <unaryop>" or "<exp1> <binaryop> <exp2>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (exp2 == null) {
			return operator + "(" + exp1 + ")";
		}
		else {
			return exp1 + " " + operator + " " + exp2;
		}
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

		AbstractOperator op = (AbstractOperator) o;

		// check if their parameters are equal (have to make sure .equals does not get called on null object.)
		if (this.exp2 == null || op.exp2 == null) {
			if (this.exp2 == null && op.exp2 == null) {
				if (this.exp1.equals(op.exp1)) {
					return true;
				}
			}
			return false;
		}
		if (!this.exp1.equals(op.exp1) && !this.exp2.equals(op.exp2)) {
			return false;
		}
		return true;
	}
}
