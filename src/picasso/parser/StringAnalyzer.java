package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.StringClass;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
import picasso.parser.tokens.IdentifierToken;
import picasso.parser.tokens.StringToken;
import picasso.parser.tokens.Token;

/**
 * Handle an identifier token
 * 
 * @author Sara Sprenkle
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface {

    @Override
    public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
        StringToken t = (StringToken) tokens.pop();

        return new StringClass(t.getValue());

        // If it is not mapped that could either mean that this could be the assignment
        // statement.
        // throw new ParseException("Error Unknown Identifier. Please assign to use.");

    }

}
