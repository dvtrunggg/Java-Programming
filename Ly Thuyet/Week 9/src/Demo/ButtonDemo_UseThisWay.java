package Demo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


//nên dùng cách này
class ButtonDemo_UseThisWay extends JFrame {
	JLabel jlab;

	ButtonDemo_UseThisWay() {
		
		setTitle("A Button Example");
		
		Container container = getContentPane();
		setLayout(new FlowLayout());
		setSize(220, 90);
		//khi tắt ứng dụng (nút X) thì ctrinh kết thúc luôn, nếu ko có dòng này thì ctrinh chạy ở background
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton jbtnUp = new JButton("Up");
		JButton jbtnDown = new JButton("Down");
		
		jbtnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlab.setText("You pressed Up.");
			}
		});

		jbtnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlab.setText("You pressed down.");
			}
		});
		
		
		add(jbtnUp);
		add(jbtnDown);
		
		jlab = new JLabel("Press a button.");
		add(jlab);
		setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonDemo_UseThisWay();
			}
		});
	}
}