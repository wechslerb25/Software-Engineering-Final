/**
 * 
 */
package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageWrap Function
 * 
 * @author
 */
public class ImageWrap extends Function {

    /**
     * Create a multiplication expression that takes as a parameter the given
     * expressions
     * 
     * @param param1 the name of the file
     * @param param2 the param for the x coordinate formula.
     * @param param3 the param for the y coordinate formula.
     */
    public ImageWrap(ExpressionTreeNode param1, ExpressionTreeNode param2, ExpressionTreeNode param3) {
        super(param1, param2, param3);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        RGBColor result2 = params.get(0).evaluate(x, y);
        RGBColor result3 = params.get(1).evaluate(x, y);
        RGBColor result1 = params.get(2).evaluate(result2.getBlue(), result3.getBlue());
        return result1;
    }

}
