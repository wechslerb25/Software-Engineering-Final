package picasso.util;

import javax.swing.JOptionPane;

public class ErrorWindow {
	
	private static boolean silenced = false;
    
    public static void setSilenced(boolean s) {
    	silenced = s;
    }
    
    // window that shows error message
    public static void showErrorPopup(String errorMessage) {
    	if(!silenced) {
    		JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
}
