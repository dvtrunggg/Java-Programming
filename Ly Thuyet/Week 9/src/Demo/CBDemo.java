package Demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

class CBDemo implements ItemListener {
	JLabel jlabSelected;
	JLabel jlabChanged;
	JCheckBox jcbAlpha;
	JCheckBox jcbBeta;
	JCheckBox jcbGamma;

	CBDemo() {
		JFrame jfrm = new JFrame("Demonstrate Check Boxes");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(280, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jlabSelected = new JLabel("");
		jlabChanged = new JLabel("");
		jcbAlpha = new JCheckBox("Alpha");
		jcbBeta = new JCheckBox("Beta");
		jcbGamma = new JCheckBox("Gamma");
		
		jcbAlpha.addItemListener(this);
		jcbBeta.addItemListener(this);
		jcbGamma.addItemListener(this);
		jfrm.add(jcbAlpha);
		jfrm.add(jcbBeta);
		jfrm.add(jcbGamma);
		jfrm.add(jlabChanged);
		jfrm.add(jlabSelected);
		jfrm.setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie) {
		String str = "";
		JCheckBox cb = (JCheckBox) ie.getItem();
		if (cb.isSelected())
			jlabChanged.setText(cb.getText() + " was just selected.");
		else
			jlabChanged.setText(cb.getText() + " was just cleared.");
		if (jcbAlpha.isSelected()) {
			str += "Alpha ";
		}
		if (jcbBeta.isSelected()) {
			str += "Beta ";
		}
		if (jcbGamma.isSelected()) {
			str += "Gamma";
		}
		jlabSelected.setText("Selected check boxes: " + str);
	}

	public static void main(String args[]) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CBDemo();
			}
		});
	}
}