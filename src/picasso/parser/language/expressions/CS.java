package picasso.parser.language.expressions;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;

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

        return new RGBColor(y, y, y);
    }

    public static void setCurrentState(Pixmap cs) {
        current_state = cs;
        return;
    }

    public static Pixmap getCurrentState() {
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
