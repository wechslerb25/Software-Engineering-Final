/**
 * @author Ben Wechsler 
 */
package picasso.view;

import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import picasso.parser.IdentifierAnalyzer;

/**
 * 
 */

public class ExpressionPanel extends JPanel {

	/**
	 * 
	 */
	private JTable exptable = new JTable(40,2);
	String variable = "";
	String expression = "";
	
	public ExpressionPanel() {
		JLabel label = new JLabel("                  Assignments        ");
		add(label);
		JLabel title = new JLabel("Variable                        Expression");
		add(title);
		this.setMinimumSize(new Dimension(300, 600));
		updatePanel();
		add(exptable);
	}
	
	public void updatePanel() {
		var entrySet = IdentifierAnalyzer.idToExpression.entrySet();
		int counter = 0;
		for (var entry : entrySet) {
			exptable.setValueAt(entry.getKey(), counter, 0);
			exptable.setValueAt(entry.getValue(), counter, 1);
			counter += 1;
		}	
		this.repaint();
	}
}

	