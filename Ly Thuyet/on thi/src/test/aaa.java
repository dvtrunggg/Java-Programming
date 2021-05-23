package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class aaa extends JFrame {
	JTextArea jtxtArea;
	JTextArea jtxtArea2;
	JTextArea jtxtArea3;
	JTextArea jtxtArea4;
	JTextArea jtxtArea5;
	JTextArea jtxtArea6;

	public aaa() {
		setTitle("ahihi");

		setLayout(new FlowLayout());
		setSize(650, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create menu bar
		JMenuBar jmb = new JMenuBar();
		// create sub menu (File)
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiLoad = new JMenuItem("Load file");
		JMenuItem jmiSave = new JMenuItem("Save file");
		JMenuItem jmiExit = new JMenuItem("Exit");

		// shortcuts (ctr+O, ctr+S, ctr+Q)
		jmiLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

		// add to menu (File)
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiExit);

		jmb.add(jmFile);

		// exit program when click exit
		jmiExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		// add menu bar to frame
		setJMenuBar(jmb);

		
		// Create JTextArea to load data
		jtxtArea = new JTextArea();
		jtxtArea.setPreferredSize( new Dimension( 400, 100 ) );
		// jtxtArea.setEditable(false);

		//
		jtxtArea2 = new JTextArea();
		jtxtArea2.setPreferredSize( new Dimension( 400, 100 ) );
		jtxtArea2.setText("\tFrom");
		
		
		
		add(jtxtArea2);
		add(jtxtArea);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new aaa();
			}
		});
	}
}
