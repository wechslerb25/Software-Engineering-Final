package picasso.util;

import javax.swing.JOptionPane;

public class ErrorWindow {

    public static void main(String[] args) {
        try {
            // code that might throw an exception; placeholder for final implementation 
            int result = divide(10, 0);
        } catch (Exception e) {
            // display the error in a pop-up window
            showErrorPopup("Error: " + e.getMessage());
        }
    }
    
    // adjust this for picasso equations and
    private static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }
    // window that shows error message
    public static void showErrorPopup(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
