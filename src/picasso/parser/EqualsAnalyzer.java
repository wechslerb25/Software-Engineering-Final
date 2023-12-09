/**
 * 
 */
package picasso.parser;

import java.beans.Expression;
import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.EqualsToken;

/**
 * SemanticAnalyzer for an Equals Token.
 * 
 * @author Sara Sprenkle
 * 
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		Token t = tokens.pop();
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Empty Assignment. Assignment failed as expression assigned to nothing.");
		}
		if(!(tokens.peek() instanceof IdentifierToken)) {
			throw new ParseException("Cannot assign non-Identifier Type.");
		}
		IdentifierToken it = (IdentifierToken) tokens.pop();
		if (it == null) {
			throw new ParseException("Empty Assignment. Assignment failed as expression assigned to nothing.");
		}
		if(it.getName().equals("x") || it.getName().equals("y")  ) {
			throw new ParseException("Cannot assign reserved Identifiers.");
		}
		IdentifierAnalyzer.idToExpression.put(it.getName(), exp1);
		return exp1;
	}
}
