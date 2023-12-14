package picasso.parser.language.expressions;

import picasso.model.Pixmap;
import picasso.parser.ParseException;
import picasso.parser.language.ExpressionTreeNode;
import picasso.view.commands.Evaluator;

/**
 * Represents the current state in a Picasso expression
 * 
 * @author Janeet Bajracharya
 * 
 */
public class CS extends ExpressionTreeNode {
    static Pixmap current_state;

    /**
     * Returns the color at x,y of current state.
     */
    @Override
    public RGBColor evaluate(double x, double y) {
        int x_coordinate = Evaluator.domainScaleToImage(x, (int) current_state.getSize().getWidth());
        int y_coordinate = Evaluator.domainScaleToImage(y, (int) current_state.getSize().getHeight());
        return new RGBColor(current_state.getColor(x_coordinate, y_coordinate));
    }

    public static void setCurrentState(Pixmap cs) {
        current_state = cs;
        return;
    }

    public static Pixmap getCurrentState() {
        if (current_state == null) {
            throw new ParseException("Invalid Use of State Aware Function! State has not been set.");
        }
        return current_state;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        return true;
    }

    /**
     * Returns "cs", the representation of this variable in Picasso expressions
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "cs";
    }
}
