package picasso.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;


public class TextBox extends JFrame {
	private Canvas canvas;
	JTextField text = new JTextField("Press Return", 40);

	public TextBox(Canvas canvas) {
		this.canvas = canvas;
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    text.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        System.out.println("Text=" + text.getText());
	      }
	    });

	    getContentPane().add(text, "Center");
	    pack();
	  }
	
	public String getText() {
		return this.text.getText();
	}


}
