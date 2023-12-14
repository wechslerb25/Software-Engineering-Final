/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.GreaterEquals;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the greater than or equals to binary operator.
 * 
 * @author Reese Nelson
 */
public class GreaterEqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //pop the less than symbol
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
		}
		ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as left expression is empty.");
		}
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new GreaterEquals(exp1, exp2);
	}
}
