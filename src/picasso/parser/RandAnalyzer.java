package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Rand;
import picasso.parser.tokens.Token;

/**
 * Handles the Parsing of Rand.
 * 
 * @author Janeet Bajracharya
 * 
 */
public class RandAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // removes Rand token
        ExpressionTreeNode ub = SemanticAnalyzer.getInstance().generateExpressionTree(
                tokens);
        ExpressionTreeNode lb = SemanticAnalyzer.getInstance().generateExpressionTree(
                tokens);
        return new Rand(lb, ub);
    }
}
