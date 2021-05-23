//package Exercise2;
//
//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.*;
//
//public class Swing extends JFrame {
//	String name;
//	JTextArea jta;
//
//	public Swing() {
//		setTitle("Chatter - " + name);
//		setLayout(new FlowLayout());
//		setSize(650, 500);
//
//		// set app in middle
//		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
//				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		// Text area
//		jta = new JTextArea(25, 80);
//		add(jta);
//		
//		setVisible(true);
//	}
//
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				new Swing();
//			}
//		});
//
//	}
//
//}
