package Demo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class TFDemo implements ActionListener {
	JTextField jtf;
	JButton jbtnRev;
	JLabel jlabPrompt, jlabContents;

	TFDemo() {
		
		//tên của cái windows:)))
		JFrame jfrm = new JFrame("Use a Text Field");
		jfrm.setLayout(new FlowLayout());
		
		//size nè
		jfrm.setSize(240, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//size của thanh nhập text
		jtf = new JTextField(10);
		jtf.setActionCommand("myTF");
		
		//tên button
		JButton jbtnRev = new JButton("Reverse");
		jtf.addActionListener(this);
		
		jbtnRev.addActionListener(this);
		
		jlabPrompt = new JLabel("Enter text: ");
		jlabContents = new JLabel("");
		
		jfrm.add(jlabPrompt);
		jfrm.add(jtf);
		jfrm.add(jbtnRev);
		jfrm.add(jlabContents);
		jfrm.setVisible(true);
	}

	//xử lý khi action listioner
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Reverse")) {
// The Reverse button was pressed.
			String orgStr = jtf.getText();
			String resStr = "";
			for (int i = orgStr.length() - 1; i >= 0; i--)
				resStr += orgStr.charAt(i);
			jtf.setText(resStr);
		} else
			jlabContents.setText("You pressed ENTER. " + "Text is: " + jtf.getText());
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TFDemo();
			}
		});
	}
}