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
	
	//add more functions

}
