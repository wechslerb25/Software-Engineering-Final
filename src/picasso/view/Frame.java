package picasso.view;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
		// Anonymous Function to Execute
//		 executeEval = ()->{};
		// Text Box
		JTextField text = new JTextField("", 20);
		text.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent action) {
		         // Is there a way to refactor this so that I dont have to do it twice.
		    	Command<Pixmap> a = new ThreadedCommand<Pixmap>(canvas, new Evaluator(text));
		    	a.execute(canvas.getPixmap());
		    	canvas.refresh();
		    }
		});
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		// Evaluator gets refrence to TextBox so it can call .getText() from it. 
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator(text)));
		commands.add("Save", new Writer());

		// add our container to Frame and show it
	    getContentPane().add(text, BorderLayout.SOUTH);
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);

		pack();
	}
}
