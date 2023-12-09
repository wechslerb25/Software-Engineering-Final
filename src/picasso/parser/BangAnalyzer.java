package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Negate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the negate unary operator.
 * 
 * @author Reese Nelson
 */
public class BangAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the negate token
		// the parameter is the next token on the stack.
		ExpressionTreeNode exp = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Invalid expression. Negate must come before valid expression or operator.");
		}
		return new Negate(exp);
	}
}
