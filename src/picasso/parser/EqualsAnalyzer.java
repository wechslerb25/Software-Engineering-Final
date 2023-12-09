/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * SemanticAnalyzer for an Equals Token.
 * 
 * @author Sara Sprenkle
 * @author Reese Nelson
 * 
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		Token t = tokens.pop();
		//check if this is for a comparison or not
		if (tokens.peek() instanceof EqualsToken) {
			//if paired with equals sign, do == operation
			tokens.pop(); //pop the equals sign
			ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			if (tokens.empty()) {
				throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
			}
			ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
			if (tokens.empty()) {
				throw new ParseException("Invalid Comparison. Comparison failed as left expression is empty.");
			}
			return new Equals(exp1, exp2);
		}
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Empty Assignment. Assignment failed as expression assigned to nothing.");
		}
		IdentifierToken it = (IdentifierToken) tokens.pop();
		if (it == null) {
			throw new ParseException("Empty Assignment. Assignment failed as expression assigned to nothing.");
		}
		IdentifierAnalyzer.idToExpression.put(it.getName(), exp1);
		return exp1;
	}
}
