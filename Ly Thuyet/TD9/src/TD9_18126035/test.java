package TD9_18126035;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame failFrame = new JFrame();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0, 4));

		JPanel leftTextFieldPanel = new JPanel();
		leftTextFieldPanel.setLayout(new FlowLayout());
		JPanel rightTextFieldPanel = new JPanel();
		rightTextFieldPanel.setLayout(new FlowLayout());

		JTextField leftTextField = new JTextField();
		leftTextField.setPreferredSize(new Dimension(150, 20));
		JTextField rightTextField = new JTextField();
		rightTextField.setPreferredSize(new Dimension(150, 20));

		leftTextFieldPanel.add(leftTextField);
		mainPanel.add(leftTextFieldPanel);

		rightTextFieldPanel.add(rightTextField);
		mainPanel.add(rightTextFieldPanel);

		mainPanel.add(new JPanel());
		mainPanel.add(rightTextFieldPanel);
		mainPanel.add(new JPanel());

		failFrame.add(mainPanel);
		failFrame.setSize(600, 400);
		failFrame.setLocationRelativeTo(null);
		failFrame.setVisible(true);

	}
}
