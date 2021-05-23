package TD11_18126035;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

public class TravelGUI {
	// Size figures
	private final int width = 300;
	private final int height = 450;
	private JPanel contentPane;
	private final String filename = "travel.txt";
	private static String strResult = "";
	private static ArrayList<Transport> travelList;
	JTextField destinationTxtField;
	JTextField cityTxtField;
	JTextPane resultTxtField;

	// Read data from file
	public String readFile(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buffer = new byte[10];
		StringBuilder sb = new StringBuilder();
		while (fis.read(buffer) != -1) {
			sb.append(new String(buffer));
			buffer = new byte[10];
		}
		fis.close();
		String result = sb.toString();
		return result;
	}

	public void fileProcessing() {
		// File processing - read input file.
		String data = "";
		try {
			data = readFile(filename);
		} catch (IOException ex) {
			System.out.println("Fail to read the input file. Please try again!");
			ex.printStackTrace();
		}
		System.out.println("Succeed in reading the input file.");
		// Data processing
		String[] line = data.split("\\r?\\n");
		Transport transport;
		// Transfer data into a list which is later used in displaying on the Jframe
		int j = 0;
		travelList = new ArrayList<Transport>();
		while (j < line.length) {
			transport = new Transport(line[j]);
			travelList.add(transport);
			strResult += transport.toString() + "\n";
			j++;
		}
	}

	public TravelGUI() {

		// JFrame processing
		// Create JFrame
		JFrame jfrm = new JFrame("My Travel");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(this.width, this.height);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create JTextArea to load data
		JTextArea jtxtArea = new JTextArea();
		jtxtArea.setPreferredSize(new Dimension(240, 100));
		jtxtArea.setEditable(false);
		// Create JPane to display components
		JPanel panelContent = new JPanel();
		panelContent.setBorder(BorderFactory.createLineBorder(Color.black));
		panelContent.add(jtxtArea);
		// Create JMenu
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiLoad = new JMenuItem("Load file - O");
		jmiLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// File processing - read file -> process data -> create data list
				fileProcessing();
				jtxtArea.setText(strResult);
			}
		});

		JMenuItem jmiClose = new JMenuItem("Close file - Q");
		jmiClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// File processing - read file -> process data -> create data list
				System.exit(0);
			}
		});

		jmiLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		jmFile.add(jmiLoad);
		jmFile.add(jmiClose);
		jmb.add(jmFile);

		// Input city
		JPanel panelInputCity = new JPanel();
		JLabel lbInputCity = new JLabel("From ");
		cityTxtField = new JTextField();
		cityTxtField.setPreferredSize(new Dimension(200, 20));
		panelInputCity.setBorder(BorderFactory.createLineBorder(Color.black));
		panelInputCity.add(lbInputCity);
		panelInputCity.add(cityTxtField);
		// Input destination
		JPanel panelInputDestination = new JPanel();
		JLabel lbInputDestination = new JLabel(" To");
		destinationTxtField = new JTextField();
		destinationTxtField.setPreferredSize(new Dimension(215, 20));
		panelInputDestination.setBorder(BorderFactory.createLineBorder(Color.black));
		panelInputDestination.add(lbInputDestination);
		panelInputDestination.add(destinationTxtField);

		// Jbutton - select functions
		JPanel panelButton = new JPanel();
		panelButton.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				boolean isFound = false;
				for (Transport item : travelList) {
					String[] str = item.getCityDestination().split("-");
					System.out.println(cityTxtField.getText());
					System.out.println(destinationTxtField.getText());
					if (cityTxtField.getText().equals(str[0]) && destinationTxtField.getText().equals(str[1])) {
						result += item.toString();
						isFound = true;
					}
				}
				if (isFound == true)
					resultTxtField.setText(result);
				else
					resultTxtField.setText("Cannot be found");
			}
		});
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cityTxtField.setText("");
				destinationTxtField.setText("");
				resultTxtField.setText("");
			}
		});
		panelButton.add(btnSearch);
		panelButton.add(btnClear);

		JPanel panelResult = new JPanel();
		JLabel lbResult = new JLabel("Result ");
		resultTxtField = new JTextPane();
		resultTxtField.setPreferredSize(new Dimension(200, 40));
		resultTxtField.setEditable(false);
		panelResult.setBorder(BorderFactory.createLineBorder(Color.black));
		panelResult.add(lbResult);
		panelResult.add(resultTxtField);
		// Add event listener

		jfrm.setJMenuBar(jmb);
		jfrm.add(panelContent);
		jfrm.add(panelInputCity);
		jfrm.add(panelInputDestination);
		jfrm.add(panelButton);
		jfrm.add(panelResult);
		jfrm.setVisible(true);
	}
}
