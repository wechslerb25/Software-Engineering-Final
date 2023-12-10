/**
 * 
 */
package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Equals;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the equals to binary operator.
 * 
 * @author Reese Nelson
 */
public class EqualsAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); //pop the equals symbol
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as right expression is empty.");
		}
<<<<<<< HEAD
		ExpressionTreeNode exp2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		if (tokens.empty()) {
			throw new ParseException("Invalid Comparison. Comparison failed as left expression is empty.");
=======
		if(!(tokens.peek() instanceof IdentifierToken)) {
			throw new ParseException("Cannot assign non-Identifier Type.");
		}
		IdentifierToken it = (IdentifierToken) tokens.pop();
		if (it == null) {
			throw new ParseException("Empty Assignment. Assignment failed as expression assigned to nothing.");
>>>>>>> refs/heads/main
		}
<<<<<<< HEAD
		ExpressionTreeNode exp1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		return new Equals(exp1, exp2);
=======
		if(it.getName().equals("x") || it.getName().equals("y")  ) {
			throw new ParseException("Cannot assign reserved Identifiers.");
		}
		IdentifierAnalyzer.idToExpression.put(it.getName(), exp1);
		return exp1;
>>>>>>> refs/heads/main
	}
}
