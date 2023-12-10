package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.language.expressions.NotEquals;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * Handles parsing the negate unary operator.
 * 
 * @author Reese Nelson
 */
public class BangAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the negate token
		//Check if part of != comparison
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
			return new NotEquals(exp1, exp2);
		}
		// the parameter is the next token on the stack.
		if (tokens.empty()) {
			throw new ParseException("Invalid expression. Negate must come before valid expression or operator.");
		}
		ExpressionTreeNode exp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Negate(exp);
		}
}
