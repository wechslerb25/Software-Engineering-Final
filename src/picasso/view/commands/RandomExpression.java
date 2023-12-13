package picasso.view.commands;

import java.util.Random;

import javax.swing.JTextField;
import picasso.model.Pixmap;
import picasso.util.Command;

/**
 * Generates a random expression
 * 
 * @author Tyler Halliday
 */

public class RandomExpression implements Command<Pixmap> {
	private final JTextField textField;
	static Random random = new Random();

	private static double getRandomConstant(double min, double max) {
		return min + (max - min) * random.nextDouble();
	}

	private static String formatConstant(double constant) {
		return constant < 0 ? "(" + constant + ")" : String.valueOf(constant);
	}

	public RandomExpression(JTextField textField) {
		this.textField = textField;

	}
	/*
	 * Generating either a random Unary function, binary operator, or leaf node
	 */

	public static String generateRandomExpression() {
		String expression = "";
		int randomExpression = random.nextInt(3);

		switch (randomExpression) {
		case 0:
			expression = generateUnaryFunction();
			break;
		case 1:
			expression = generateBinaryOperator();
			break;
		case 2:
			expression = generateLeafNode();
			break;
		}
		return expression;
	}

	/*
	 * Generates a random binaryOperator
	 */
	public static String generateBinaryOperator() {

		char binaryOperator = 0;

		int operatorCode = random.nextInt(4);

		switch (operatorCode) {
		case 0:
			binaryOperator = '+';
			break;
		case 1:
			binaryOperator = '-';
			break;
		case 2:
			binaryOperator = '*';
			break;
		case 3:
			binaryOperator = '/';
			break;
		}

		return generateRandomExpression() + " " + binaryOperator + " " + generateRandomExpression();
	}

	/*
	 * Generates either x, y, constants, or colors randomly
	 * 
	 */
	public static String generateLeafNode() {
		String variable = "";
		int variableType = random.nextInt(4);

		switch (variableType) {
		case 0:
			variable = "x";
			break;
		case 1:
			variable = "y";
			break;
		case 2:
			double red = getRandomConstant(-1, 1);
			double green = getRandomConstant(-1, 1);
			double blue = getRandomConstant(-1, 1);
			variable = String.format("[%.2f, %.2f, %.2f]", red, green, blue);
			break;
		case 3:
			double variable1 = getRandomConstant(-1, 1);
			variable = formatConstant(variable1);
			break;
		}
		return variable;
	}

	/*
	 * Generates a random unary function
	 */
	public static String generateUnaryFunction() {
		String[] unaryFunction = { "sin", "cos", "floor", "ceil", "abs", "tan", "atan", "exp", "log" };
		int unaryFuncIndex = random.nextInt(unaryFunction.length);
		String selectUnaryFunc = unaryFunction[unaryFuncIndex];
		return selectUnaryFunc + "(" + generateRandomExpression() + ")";

	}

	@Override
	public void execute(Pixmap target) {
		String expression = generateRandomExpression();

		textField.setText(expression);

	}
}
