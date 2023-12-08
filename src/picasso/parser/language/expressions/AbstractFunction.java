package picasso.parser.language.expressions;

import java.util.List;
import java.util.ArrayList;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one or more arguments.
 * 
 * @author Reese Nelson
 */
public abstract class AbstractFunction extends ExpressionTreeNode {

	List<ExpressionTreeNode> params;

	/**
	 * Creates a function
	 * @param param1 ExpressionTreeNode to evaluate
	 */
	public AbstractFunction(ExpressionTreeNode param1) {
		this.params = new ArrayList<ExpressionTreeNode>();
		this.params.add(param1);
	}
	/**
	 * Creates a function
	 * @param param1 ExpressionTreeNode to evaluate
	 * @param param2 ExpressionTreeNode to evaluate
	 */
	public AbstractFunction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this(param1);
		this.params.add(param2);
	}
	/**
	 * Creates a function
	 * @param param1 ExpressionTreeNode to evaluate
	 * @param param2 ExpressionTreeNode to evaluate
	 * @param param3 ExpressionTreeNode to evaluate
	 */
	public AbstractFunction(ExpressionTreeNode param1, ExpressionTreeNode param2, ExpressionTreeNode param3) {
		this(param1, param2);
		this.params.add(param3);
	}
	/**
	 * Creates a function
	 * @param params ExpressionTreeNodes to evaluate
	 */
	public AbstractFunction(ExpressionTreeNode[] params) {
		for (ExpressionTreeNode n : params) {
			this.params.add(n);
		}
	}

	/**
	 * Returns the string representation of the function in the format 
	 * "<ClassName>(<parameter1>, <parameter2>, ...)"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		String comma = ", ";
		StringBuilder sb = new StringBuilder();
		sb.append(classname.substring(classname.lastIndexOf(".") + 1).toLowerCase());
		sb.append("(");
		for (int i =  0; i < params.size()-1; i++) {
			sb.append(params.get(i));
			sb.append(comma);
		}
		sb.append(params.get(params.size()-1));
		sb.append(")");
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof AbstractFunction)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		AbstractFunction uf = (AbstractFunction) o;

		// check if their parameters are equal
		if (this.params.size() != uf.params.size()) {
			return false;
		}
		for (int i = 0; i < params.size(); i++) {
			if (!this.params.get(i).equals(uf.params.get(i))) {
				return false;
			}
		}
		return true;
	}
}
