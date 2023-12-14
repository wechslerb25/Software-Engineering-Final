package picasso.view.commands;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.CS;
import picasso.util.Command;
import picasso.view.ExpressionPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 * @author Sara Sprenkle
 */
public class Evaluator implements Command<Pixmap> {
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	private JTextField text;
	private ExpressionPanel expanel;

	// create the expression to evaluate just once
	public Evaluator(JTextField text, ExpressionPanel expanel) {
		this.text = text;
		this.expanel = expanel;
	}

	/**
	 * Evaluate an expression for each point in the image.
	 */

	public void pixelEvaluator(Pixmap target, ExpressionTreeNode expr) {
		//Handle null
		if (expr!=null) {
			Dimension size = target.getSize();
			CS.setCurrentState(new Pixmap(target));
			for (int imageY = 0; imageY < size.height; imageY++) {
				double evalY = imageToDomainScale(imageY, size.height);
				for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor = expr.evaluate(evalX, evalY).toJavaColor();
					target.setColor(imageX, imageY, pixelColor);
				}
			}
		}
	}

	public void execute(Pixmap target) {
		execute(target,text.getText());
		
	}

	public void execute(Pixmap target, String expression) {
		ExpressionTreeNode expr = createExpression(expression);
		pixelEvaluator(target, expr);
		expanel.updatePanel();
	}

	/**
	 * Convert from image space to domain space.
	 */
	protected double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}

	/**
	 * Convert from domain space to image space.
	 */
	public static int domainScaleToImage(double value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return (int) (((value - DOMAIN_MIN) * bounds) / range);
	}

	/**
	 * 
	 * A place holder for a more interesting way to build the expression.
	 */
	private ExpressionTreeNode createExpression(String expression) {
		// Note, when you're testing, you can use the ExpressionTreeGenerator to
		// generate expression trees from strings, or you can create expression
		// objects directly (as in the commented statement below).
		// String test = "x + y";

		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		return expTreeGen.makeExpression(expression);

		// return new Multiply( new X(), new Y() );
	}
}
