package picasso.parser.language.expressions;

/**
 * Random Color Generator.
 * 
 * @author Reese Nelson
 */
public class Random extends AbstractFunction {
    /**
     * Initialization
     * 
     */
    public Random() {
        super();
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        return new RGBColor(Math.random() * 2 - 1, Math.random() * 2 - 1, Math.random() * 2 - 1);
    }

}
