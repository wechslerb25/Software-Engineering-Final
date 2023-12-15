package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.If;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the if function.
 * @author Reese Nelson
 */
public class IfAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the token
		// the parameter is the next token(s) on the stack.
		// But, it needs to be processed
		ExpressionTreeNode param3 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode param1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new If(param1, param2, param3);
	}
}
