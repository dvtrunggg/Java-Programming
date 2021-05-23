package TD9_18126035;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TD9 extends JFrame implements ActionListener {
	JLabel jlab1;
	JLabel jlab2;
	JPanel panel;
	JTextArea jta;
	int maxNum = 0;
	int secNum = 0;

	public TD9() {
		setTitle("Find the largest and second largest numbers");

		setLayout(new FlowLayout());
		setSize(650, 500);

		// set app in middle
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

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

		jta = new JTextArea(18, 68);
		add(jta);

		// button
		JButton jbtSubmit = new JButton("Submit");
		JButton jbtClear = new JButton("Clear");
		JButton jbtChart = new JButton("Chart");

		// action listener of button
		jbtSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String temp[] = jta.getText().split("\n");
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 0; i < temp.length; i++) {
					list.add(Integer.parseInt(temp[i]));
				}

				String str = "Max number: " + Collections.max(list) + "      Second max number: " + findSecNum(list);
				jlab1.setText(str);

			}
		});

		jbtClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jta.setText("");
				jlab1.setText("Max number: " + 0 + "      Second max number: " + 0);
			}
		});

		add(jbtSubmit);
		add(jbtClear);
		add(jbtChart);
		// result label

		jlab1 = new JLabel("Max number: " + maxNum + "      Second max number: " + secNum);
		add(jlab1);

		// add action listener
		jmiLoad.addActionListener(this);
		jmiSave.addActionListener(this);
		jbtChart.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Load file")) {
			JFileChooser fc = new JFileChooser();
			int response = fc.showOpenDialog(null); // select file to open

			if (response == JFileChooser.APPROVE_OPTION) {
				File path = new File(fc.getSelectedFile().getAbsolutePath());
				// System.out.println(file);

				ArrayList<String> data = readFile(path.toString());

				String str = "";
				for (int i = 0; i < data.size(); i++) {
					str += data.get(i) + "\n";
				}
				jta.setText(str);

				// count the number of characters, lines, words in the file just opened

				int words = 0;
				int lines = 0;
				int chars = 0;
				Scanner in;
				try {
					in = new Scanner(path);
					while (in.hasNextLine()) {
						lines++;
						String line = in.nextLine();
						chars += line.length();
						words += new StringTokenizer(line, " ,").countTokens();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				jlab1.setText("Words: " + words + "   Lines: " + lines + "   Chars: " + chars);

			}
		}

		// save file
		else if (e.getActionCommand().equals("Save file")) {
			JFileChooser fc = new JFileChooser();
			int response = fc.showSaveDialog(null); // select file to open
			if (response == JFileChooser.APPROVE_OPTION) {
				File path = new File(fc.getSelectedFile().getAbsolutePath());
				ArrayList<String> data = new ArrayList<>();
				String str[] = jta.getText().split("\n");
				for (int i = 0; i < str.length; i++) {
					data.add(str[i]);
				}

				writeFile(data, path.toString());
				jta.setText("");
				jlab1.setText("Max number: " + 0 + "      Second max number: " + 0);

			}
		}

		// draw chart
		else if (e.getActionCommand().equals("Chart")) {
			ArrayList<Integer> data = new ArrayList<>();

			String str[] = jta.getText().split("\n");
			for (int i = 0; i < str.length; i++) {
				data.add(Integer.parseInt(str[i]));
			}

			final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < data.size(); i++) {
				dataset.addValue(data.get(i), "Limit", data.get(i));
			}
			JFreeChart barChart = ChartFactory.createBarChart("Chart", "Number", "Limit", dataset,
					PlotOrientation.VERTICAL, false, false, false);
			
			ChartPanel chartPanel = new ChartPanel(barChart);
			chartPanel.setPreferredSize(new java.awt.Dimension(200, 100));
			add(chartPanel);

		}

	}

	public static int countOccurrences(ArrayList<Integer> list, int n, int x) {
		int res = 0;
		for (int i = 0; i < list.size(); i++)
			if (x == list.get(i))
				res++;
		return res;
	}

	// find largest and 2nd largest in array number
	public static int findSecNum(ArrayList<Integer> list) {

		int maxNum = Math.max(list.get(0), list.get(1));
		int secNum = Math.min(list.get(0), list.get(1));

		for (int i = 2; i < list.size(); i++) {
			if (maxNum < list.get(i)) {
				secNum = maxNum;
				maxNum = list.get(i);
			} else if (secNum < list.get(i)) {
				secNum = list.get(i);
			}
		}
		return secNum;

	}

	// read data from file
	public static ArrayList<String> readFile(String path) {
		ArrayList<String> data = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();
			while (line != null) {
				if (line.length() > 0)
					data.add(line);
				line = br.readLine();
			}

			br.close();
			isr.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// write data to file
	public static void writeFile(ArrayList<String> data, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

			for (String dt : data) {
				bw.write(dt);
				bw.newLine();
			}

			bw.newLine();
			bw.close();
			osw.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new TD9();
			}
		});

	}

}
