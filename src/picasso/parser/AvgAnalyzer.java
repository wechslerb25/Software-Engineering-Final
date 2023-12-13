package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Avg;
import picasso.parser.tokens.Token;

/**
 * Handles Parsing for Avg_R
 * 
 * @author Janeet Bajracharya
 */
public class AvgAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Need to remove the avg_r token
        return new Avg();
    }
}
