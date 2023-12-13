package picasso.parser.language.expressions;

import picasso.view.commands.Evaluator;

public class Avg extends AbstractFunction {

	/**
	 * 
	 * @param param1 Radius Of Pixels.
	 */
	public Avg() {
		super();
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		int height = (int) CS.getCurrentState().getSize().getHeight();
		int width = (int) CS.getCurrentState().getSize().getWidth();
		int r = 1;

		int current_x = Evaluator.domainScaleToImage(x, width);
		int current_y = Evaluator.domainScaleToImage(y, height);
		int lower_x = clamp(current_x - r, 0, width - 1);
		int upper_x = clamp(current_x + r, 0, width - 1);
		int lower_y = clamp(current_y - r, 0, height - 1);
		int upper_y = clamp(current_y + r, 0, height - 1);
		// System.out.printf("X: %d, %d\n", lower_x, upper_x);
		// System.out.printf("Y: %d, %d\n", lower_y, upper_y);
		double avg = 0;
		int count = 0;
		for (int i = lower_x; i < upper_x + 1; i++) {
			for (int j = lower_y; j < upper_y + 1; j++) {
				avg += new RGBColor(CS.getCurrentState().getColor(i, j)).getRed();
				count++;
			}
		}
		count--;
		avg -= new RGBColor(CS.getCurrentState().getColor(current_x, current_y)).getRed();
		avg /= count;
		// System.out.printf("Avg: %f\n", avg);
		return new RGBColor(avg, avg, avg);
	}

	private int clamp(int val, int min, int max) {
		return Math.max(min, Math.min(max, val));
	}

}
