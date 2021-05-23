package Test;

import javax.swing.JFrame;

public class HelloSwing {
	public HelloSwing() {
		JFrame frame = new JFrame("Hello");
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.add(frame)
	}

	public static void main(String[] args) {
		new HelloSwing();
	}
}
