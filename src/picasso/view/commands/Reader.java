package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import java.util.Scanner;

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
		    int PeriodIndex = fileName.lastIndexOf(".");  //gets the index of the last occurrence of a period in the string
		    String NewString = fileName.substring(PeriodIndex + 1); //slices the string from the period to the end exclusively
		    NewString = NewString.toLowerCase();
		    System.out.println(NewString);
		    
	    	if (NewString.equals("txt")) {
	    		System.out.println(fileName);
	    		Scanner scan = new Scanner(fileName);
	    		expression = scan.nextLine();
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
