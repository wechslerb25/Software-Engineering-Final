/**
 * @author Ben Wechsler 
 */
package picasso.view;

import java.awt.Dimension;
import java.awt.LayoutManager;
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
	String variable = "";
	String expression = "";
	public ExpressionPanel() {
		JLabel label = new JLabel("Assignments");
		add(label);
		this.setMinimumSize(new Dimension(300, 600));
		int rows = IdentifierAnalyzer.idToExpression.size();
		JTable exptable = new JTable(rows, 2);
		var entrySet = IdentifierAnalyzer.idToExpression.entrySet();
		int counter = 0;
		for (var entry : entrySet) {
			exptable.setValueAt(entry.getKey(), counter, 0);
			exptable.setValueAt(entry.getValue(), counter, 1);
			counter += 1;
		}
		add(exptable);
	}
}

	