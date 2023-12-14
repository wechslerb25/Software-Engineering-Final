package picasso.view;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import picasso.model.Pixmap;
import picasso.parser.IdentifierAnalyzer;
import picasso.util.Command;
import picasso.util.ThreadedCommand;
import picasso.util.RepeatedThreadedCommand;
import picasso.view.commands.*;
import picasso.view.commands.Reader;
import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.expressions.*;

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
		ExpressionPanel expanel = new ExpressionPanel(); 
		expanel.setLayout(new BoxLayout(expanel,BoxLayout.Y_AXIS));
		
		Evaluator evaluator = new Evaluator(text, expanel);
		
		text.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent action) {
		         // Is there a way to refactor this so that I dont have to do it twice.
		    	Command<Pixmap> a = new ThreadedCommand<Pixmap>(canvas, evaluator);
		    	a.execute(canvas.getPixmap());
		    	canvas.refresh();
		    }
		});
		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		Reader read = new Reader(evaluator, text);
		commands.add("Open", read);
		//gets the expression from the reader class
		// Evaluator gets refrence to TextBox so it can call .getText() from it.


		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, evaluator));
		commands.add("Save", new Writer());
		Player player = Player.getInstance(evaluator);
		commands.add("Play", new RepeatedThreadedCommand<Pixmap>(canvas, player));
		commands.getComponent(3).setName("Stop");
	
		RandomExpression random = new RandomExpression(text);
		commands.add("Random", new ThreadedCommand<Pixmap>(canvas, random));
		// add our container to Frame and show it
	    getContentPane().add(text, BorderLayout.SOUTH);
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(expanel, BorderLayout.EAST);

		pack();
	}
}
