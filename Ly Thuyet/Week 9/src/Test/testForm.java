package Test;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;

public class testForm  implements ActionListener{

	JLabel data;
	JMenuBar jmb = new JMenuBar();
	JMenu jmFile = new JMenu("File");
	
	JMenuItem LoadFile = new JMenuItem("Load file");
	JMenuItem SaveFile = new JMenuItem("Save file");
	JMenuItem CloseFile = new JMenuItem("Close");

	JTextPane dataPane = new JTextPane();
	JPanel result = new JPanel();
	JPanel button = new JPanel();


	testForm(){
		JFrame jframe = new JFrame();
		jframe.setTitle("Find the largest and second largest numbers");
		jframe.setSize(500, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LoadFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		SaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		CloseFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setBounds(0, 0, 500, 250);
		scrollPane.add(dataPane);
		
		
		jmFile.add(LoadFile);
		jmFile.add(SaveFile);
		jmFile.addSeparator();
		jmFile.add(CloseFile);
		jmb.add(jmFile);
		
		LoadFile.addActionListener(this);
		SaveFile.addActionListener(this);
		CloseFile.addActionListener(this);
		
    	jframe.getContentPane().add(scrollPane, BorderLayout.NORTH);
    	jframe.getContentPane().add(result, BorderLayout.CENTER);
    	jframe.getContentPane().add(button, BorderLayout.SOUTH);

    	result.setLayout(null);
    	
		jframe.setJMenuBar(jmb);
		jframe.setVisible(true);
		
	}
	
	
	public void LoadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		    String S = "", s = "";
		    ArrayList<Integer> data = new ArrayList<>();
		    
		    while((s = br.readLine()) != null) {
		    	S += s + "\n";
		    	data.add(Integer.parseInt(s));
		    }
		    dataPane.setText(S);
	    	System.out.println(S);
		    br.close();

		} catch (Exception event) {
			event.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == LoadFile) {
			LoadFile();
		}
		if (e.getSource() == CloseFile) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new testForm();
			}
		});
	}
}
