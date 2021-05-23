package Demo;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

/////version 1
//class SwingDemo1 extends JFrame {
//public SwingDemo1() {
//	Container cp = getContentPane();
//	cp.setLayout(new FlowLayout());
//	cp.add(new JLabel("Hello, world!"));
//	cp.add(new JButton("Button"));
//	setSize(200, 200);
//	setVisible(true);
//}
//
//public static void main(String[] args) {
//	new SwingDemo1();
//}
//}

////version2 recommend to use
public class SwingDemo1 {
	SwingDemo1() {
		JFrame jfrm = new JFrame("A Simple Swing Application");
		jfrm.setSize(275, 100);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab = new JLabel(" Swing defines the modern Java GUI.");
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public static void main(String args[]) {

		// tạo luồng (thread) giúp chạy nhanh hơn nếu nhiều nếu giao diện phức tạp.
		// tạo even quản lý:

		// invokelater: đối tượng vừa tạo ra dc chạy luôn
		// SwingUtilities.invokeAndWait(code) : đợi sau khi object dc thực thi thì mới
		// chạy:))
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo1();
			}

		});

	}
}



