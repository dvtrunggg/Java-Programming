package Demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ListDemo implements ListSelectionListener {
	JList<String> jlst;
	JLabel jlab;
	JScrollPane jscrlp;
	String names[] = { "Sherry", "Jon", "Rachel", "Sasha", "Josselyn", "Randy", "Tom", "Mary", "Ken", "Andrew", "Matt",
			"Todd" };

	ListDemo() {
		JFrame jfrm = new JFrame("JList Demo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 350);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlst = new JList<String>(names);
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jscrlp = new JScrollPane(jlst);
		jscrlp.setPreferredSize(new Dimension(300, 300));
		jlab = new JLabel("Please choose a name");
		jlst.addListSelectionListener(this);
		jfrm.add(jscrlp);
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent le) {
		int idx = jlst.getSelectedIndex();
		if (idx != -1)
			jlab.setText("Current selection: " + names[idx]);
		else
			jlab.setText("Please choose an name");
	}

	public static void main(String args[]) {
// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ListDemo();
			}
		});
	}
}
