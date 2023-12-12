package picasso.parser.language.expressions;

import picasso.view.commands.Evaluator;

/**
 * Returns the RGB value of the pixel at (x,y) at (t-1).
 * 
 * @author Janeet Bajracharya
 */

public class Pixel extends AbstractFunction {

    /**
     * Args Less
     */
    public Pixel() {
        super();
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        int height = (int) CS.getCurrentState().getSize().getHeight();
        int width = (int) CS.getCurrentState().getSize().getWidth();
        int current_x = Evaluator.domainScaleToImage(x, width);
        int current_y = Evaluator.domainScaleToImage(y, height);
        RGBColor color = new RGBColor(CS.getCurrentState().getColor(current_x, current_y));
        return new RGBColor(CS.getCurrentState().getColor(current_x, current_y));
    }

}
