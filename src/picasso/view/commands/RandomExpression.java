package picasso.view.commands;

import java.util.Random;
import javax.swing.JTextField;
import picasso.model.Pixmap;
import picasso.util.Command;

public class RandomExpression implements Command<Pixmap> {
	private final JTextField textField;
	static Random random = new Random();

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
	 * Generates either x, y, constants, or colors
	 */
	public static String generateLeafNode() {
		String variable = random.nextBoolean() ? "x" : "y";
		return variable;
	}
	/*
	 * Change from 0,1 to sin cos
	 */
	public static String generateUnaryFunction() {
		String[] unaryFunction = { "sin", "cos" };
		int unaryFuncIndex = random.nextInt(unaryFunction.length);
		String selectUnaryFunc = unaryFunction[unaryFuncIndex];
		return selectUnaryFunc + "(" + generateRandomExpression() + ")";

	}

	@Override
	public void execute(Pixmap target) {
		String expression = generateRandomExpression();
		System.out.println(expression);

		textField.setText(expression);

	}
}
