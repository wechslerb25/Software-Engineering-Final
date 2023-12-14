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
	public JTable exptable = new JTable(40,2); //Seems like there's no add row/resize option? if thats the case then I guess I have to remake the table
	String variable = "";
	String expression = "";
	
	public ExpressionPanel() {
		JLabel label = new JLabel("Assignments");
		add(label);
		this.setMinimumSize(new Dimension(300, 600));
		updatePanel(exptable);
	}
	
	public void updatePanel(JTable exptable) {
		//int rows = IdentifierAnalyzer.idToExpression.size(); Like this? or hard code number of rows
		//Could set up the table with all rows I need, so I can just update the rows here instead of making new table
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

	