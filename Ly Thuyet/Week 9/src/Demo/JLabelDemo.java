package Demo;

import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelDemo extends JFrame {
	public JLabelDemo() {
		Container cp = getContentPane();
		ImageIcon ii = new ImageIcon("hourgelass.png");
		JLabel jl = new JLabel("Hourglass", ii, JLabel.CENTER);

		cp.add(jl);
		setSize(200, 200);
		setVisible(rootPaneCheckingEnabled);
	}

	public static void main(String[] args) {
		new JLabelDemo();
	}
}
