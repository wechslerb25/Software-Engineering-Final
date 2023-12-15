package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Random;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Random function.
 * @author Reese Nelson
 */
public class RandomAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the token
		// the parameter is the next token(s) on the stack.
		// But, it needs to be processed
		return new Random();
	}

}
