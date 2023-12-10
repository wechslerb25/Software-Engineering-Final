/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.NotEquals;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the not equals to binary operator.
 * 
 * @author Reese Nelson
 */
public class NotEqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //pop the not equals symbol
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
		}
		ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as left expression is empty.");
		}
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new NotEquals(exp1, exp2);
	}
}
