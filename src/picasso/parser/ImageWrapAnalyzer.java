package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.ImageWrap;

import picasso.parser.tokens.Token;

public class ImageWrapAnalyzer extends UnaryFunctionAnalyzer {

    @Override
    public ImageWrap generateExpressionTree(Stack<Token> tokens) {
        tokens.pop(); // Need to remove the cos token
        // the parameter is the next token(s) on the stack.
        // But, it needs to be processed
        ExpressionTreeNode param1 = SemanticAnalyzer.getInstance().generateExpressionTree(
                tokens);
        ExpressionTreeNode param2 = SemanticAnalyzer.getInstance().generateExpressionTree(
                tokens);
        ExpressionTreeNode param3 = SemanticAnalyzer.getInstance().generateExpressionTree(
                tokens);

        return new ImageWrap(param3, param2, param1);
    }

}
