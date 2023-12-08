/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ImageWrap Function
 * 
 * @author
 */
public class ImageWrap extends TernaryFunction {

    /**
     * Create a multiplication expression that takes as a parameter the given
     * expressions
     * 
     * @param exp1 the name of the file
     * @param exp2 the param for the x coordinate formula.
     * @param exp3 the param for the y coordinate formula.
     */
    public ImageWrap(ExpressionTreeNode param1, ExpressionTreeNode param2, ExpressionTreeNode param3) {
        super(param1, param2, param3);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        RGBColor result2 = param2.evaluate(x, y);
        RGBColor result3 = param3.evaluate(x, y);
        RGBColor result1 = param1.evaluate(result2.getBlue(), result3.getBlue());
        return result1;
    }

}
