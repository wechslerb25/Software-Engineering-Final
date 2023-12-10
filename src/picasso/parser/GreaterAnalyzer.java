/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.GreaterEquals;
import picasso.parser.language.expressions.GreaterThan;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * Handles parsing the greater than binary operator.
 * 
 * @author Reese Nelson
 */
public class GreaterAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //pop the less than symbol
		if (tokens.peek() instanceof EqualsToken) {
			//if paired with equals sign, do >= operation
			tokens.pop(); //pop the equals sign
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
		else {
			//do < operation
			if (tokens.empty()) {
				throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
			}
			ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			if (tokens.empty()) {
				throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
			}
			ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			return new GreaterThan(exp1, exp2);
		}
	}
}
