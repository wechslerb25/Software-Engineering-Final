package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Pixel;
import picasso.parser.tokens.Token;

/**
 * Handles the Parsing of Pixel.
 * 
 * @author Janeet Bajracharya
 * 
 */
public class PixelAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // removes Pixel token
        return new Pixel();
    }
}
