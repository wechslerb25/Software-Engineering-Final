package picasso.view.commands;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class Reader extends FileCommand<Pixmap> {

	private Evaluator eval;
	private final JTextField textField;

	/**
	 * Creates a Reader object, which prompts users for image files to open
	 */
	public Reader(JTextField textField) {
		super(JFileChooser.OPEN_DIALOG);
		this.textField = textField;
	}

	public Reader(Evaluator eval, JTextField textField) {
		super(JFileChooser.OPEN_DIALOG);
		this.eval = eval;
		this.textField = textField;
	}

	/**
	 * Displays the image file on the given target.
	 */
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			int periodIndex = fileName.lastIndexOf("."); // gets the index of the last occurrence of a period in the
															// string
			String extension = fileName.substring(periodIndex + 1); // slices the string from the period to the end
																	// exclusively
			extension = extension.toLowerCase();
			if (extension.equals("exp")) {
				File file = new File(fileName);
				Scanner scan;
				try {
					scan = new Scanner(file);
					StringBuilder expression = new StringBuilder();
					while (scan.hasNextLine()) {
						expression.append(scan.nextLine());
						eval.execute(target, expression.toString());
						textField.setText(expression.toString()); //set the text field to have the expression
					}
					scan.close();
				} catch (FileNotFoundException e) {
					System.err.println("File not found. Running default expression... ");
					eval.execute(target);
					e.printStackTrace();
					
				}
			}

			else {
				target.read(fileName);
			}
		}
	}
}
