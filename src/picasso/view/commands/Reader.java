package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import java.util.Scanner;
import java.io.File;
import java.util.*;

/**
 * Open the chosen image file and display in the Pixmap target.
 * 
 * @author Robert C Duvall
 */
public class Reader extends FileCommand<Pixmap> {

	/**
	 * Creates a Reader object, which prompts users for image files to open
	 */
	public Reader() {
		super(JFileChooser.OPEN_DIALOG);
	}

	/**
	 * Displays the image file on the given target.
	 */
	String expression = null;
	public void execute(Pixmap target) {
		String fileName = getFileName();
	    if (fileName != null) {
		    int periodIndex = fileName.lastIndexOf(".");  //gets the index of the last occurrence of a period in the string
		    String extension = fileName.substring(periodIndex + 1); //slices the string from the period to the end exclusively
		    extension = extension.toLowerCase();
		    System.out.println(extension);
		    
	    	if (extension.equals("exp")) {
	    		System.out.println(fileName);
	    		File file = new File("/Users/bwech/Documents/School_stuff/Software_Development/picasso-codecatalysts/sin(x).txt");
	    		Scanner scan = new Scanner(file);
	    		StringBuilder expression = new StringBuilder();
	    		expression.append(scan.nextLine());
	    		while (scan.hasNextLine()) {
	    			expression.append(scan.nextLine());
	    		}
	    		System.out.println(expression);
	    		scan.close();
	    	}
	    	
	    	else {
	    		target.read(fileName);
	    	}
	    }
	}
	public String getExpression() {
		return expression;
	}
}
