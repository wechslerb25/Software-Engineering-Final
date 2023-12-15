package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RgbToYCrCb;
import picasso.parser.tokens.Token;

public class RgbToYCrCBAnalyzer implements SemanticAnalyzerInterface {
	
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the rgbToYCrCb token
		// the parameter is the next token(s) on the stack.
		// But, it needs to be processed
		ExpressionTreeNode paramETN = SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens);
		return new RgbToYCrCb(paramETN);
	}
}