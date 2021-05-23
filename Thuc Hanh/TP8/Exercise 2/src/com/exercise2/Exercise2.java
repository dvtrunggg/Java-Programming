package com.exercise2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.TextArea;

public class Exercise2 extends JFrame {

	private JPanel contentPane;
	private JTextField searchBox;
	private final JList listTitle = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exercise2 frame = new Exercise2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Exercise2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 786, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnShowHide = new JButton("SHOW/HIDE");
		btnShowHide.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowHide.setBounds(10, 10, 147, 25);
		panel.add(btnShowHide);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(189, 10, 95, 25);
		panel.add(btnDelete);

		JButton btnNote = new JButton("NOTE");
		btnNote.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNote.setBounds(294, 10, 95, 25);
		panel.add(btnNote);

		searchBox = new JTextField();
		searchBox.setBounds(404, 10, 253, 25);
		panel.add(searchBox);
		searchBox.setColumns(10);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(663, 10, 113, 25);
		panel.add(btnSearch);
		listTitle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		listTitle.setModel(new AbstractListModel() {
			String[] values = new String[] { "Apple's Notes app is qui", "It hasn't been long since" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listTitle.setSelectedIndex(1);
		listTitle.setSelectedIndex(2);
		listTitle.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		listTitle.setBackground(UIManager.getColor("Button.background"));
		listTitle.setBounds(0, 46, 243, 517);
		contentPane.add(listTitle);

		JLabel lbDateCreated = new JLabel("April 6, 2016 at 9:58 AM", SwingConstants.CENTER);
		lbDateCreated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDateCreated.setBounds(244, 48, 542, 34);
		contentPane.add(lbDateCreated);
		String content = "It hasn't been long since the last RSC production of Hamlet. In 2013, the RSC featured nathan Slinger as Hamlet, in an introspective performance. Slightly older is the David Tennant Hamlet, available on DVD and Blu-Ray ( n, /Amazon 1. ), with another psychological approach to the role.\n"
				+ "But this year's Hamlet takes a different tack. The 25-year old actor Papa Essiedu portrays a Hamlet that is petulant and impulsive, one who wears his madness as a badge of pride. But is his madness real or just feigned?\n"
				+ "Essiedu's story is interesting. He was first noticed when, as an understudy, he had to take over a role of Edmund,  in mid-performance,  in the National Theatre's King  Lear with Simon Russe  Br . The RSC then asked him to play Hamlet, the first black Hamlet in this company's history. This 25-year old inhabits the character with aplomb, portraying both the serious side and the manic side of the character with ease and grace. ";
		TextArea textArea = new TextArea(content);
		textArea.setEditable(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 16));
		textArea.setBounds(249, 88, 537, 475);
		contentPane.add(textArea);
	}
}
