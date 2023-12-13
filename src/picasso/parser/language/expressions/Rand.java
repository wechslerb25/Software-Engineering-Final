package picasso.parser.language.expressions;

import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Random Number Generator.
 * 
 * @author Janeet Bajracharya
 */
public class Rand extends AbstractFunction {
    /**
     * Initialization
     * 
     * @param lower_bound Lower Bound For Random Number Generator [-1,1]
     * @param upper_bound Upper Bound For Random Number Generator [-1,1]
     */
    public Rand(ExpressionTreeNode lower_bound, ExpressionTreeNode upper_bound) {
        super(lower_bound, upper_bound);
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        double lb = params.get(0).evaluate(x, y).getRed();
        double ub = params.get(1).evaluate(x, y).getRed();
        if (lb > ub) {
            new ParseException("Lower Bound Must Be Smaller Than Upper Bound.");
        }
        double randomValue = lb + (Math.abs(lb) + Math.abs(ub)) * Math.random();
        return new RGBColor(randomValue, randomValue, randomValue);
    }

}
