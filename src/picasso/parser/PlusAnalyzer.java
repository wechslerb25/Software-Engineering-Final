package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the addition binary operator.
 * 
 * @author Reese Nelson
 */
public class PlusAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the plus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Addition(exp1, exp2);
	}
}
