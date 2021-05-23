package Exercice02;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.io.*;

@SuppressWarnings("serial")
public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField message;
	private JTextArea ChatArea;
	private JTextField name;
	private JButton confirmButton;
	private Socket socket; 
	private OutputStream out ; 
	private Writer ouw;
	private BufferedWriter bfw;
	private JButton logoutButton;
	String nameText;


	public static void main(String[] args) throws IOException {
		Client app = new Client();
		app.connect();
		app.listen();
	}
	
	public void connect() throws IOException {
		int port = 2222;
		socket = new Socket("localhost", port);
		out = socket.getOutputStream();
		ouw = new OutputStreamWriter(out);
		bfw = new BufferedWriter(ouw);
		bfw.write(name.getText() + "\r\n");
		bfw.flush();
	}
	
	public void sendMessage(String msg) throws IOException {
		if (msg.equals("Logout")) { 
			bfw.write("Disconnected \r\n");
		} else { 
			bfw.write(msg + "\r\n"); 
			ChatArea.append(name.getText() + ": " + message.getText() + "\r\n"); 
		}
		bfw.flush(); 
		message.setText("");
	}
	
	public void listen() throws IOException{ 
		InputStream in = socket.getInputStream(); 
		InputStreamReader inr = new InputStreamReader(in); 
		BufferedReader bfr = new BufferedReader(inr); 
		String msg = "";
		while(!"Logout".equalsIgnoreCase(msg)) {
			if (bfr.ready()) { 
				msg = bfr.readLine();
				if (msg.equals("Logout")) {
					ChatArea.append("Server out! \r\n");
				} else ChatArea.append(msg + "\r\n"); 
			} 
		}
	}
	
	public void close() {
		try {
			sendMessage("Logout");
			bfw.close();
		    ouw.close();
		    out.close();
		    socket.close();

		} catch (IOException e) {
			System.out.println("I/O error " + e);

		}
	}
	
	/**
	 * Create the frame.
	 */
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 110, 610, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		message = new JTextField();
		message.setColumns(10);
		
		JButton sendButton = new JButton("SEND");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sendMessage(message.getText());
				} catch (IOException e1) {
			System.out.println("I/O error " + e);

				}
			}
		});
		
		ChatArea = new JTextArea();
		ChatArea.setFont(new Font("Consolas", Font.PLAIN, 20));
		ChatArea.setEditable(false);
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setEditable(false);
			}
		});
		
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ChatArea, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(message, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
							.addComponent(confirmButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(logoutButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(ChatArea, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(logoutButton)
							.addComponent(confirmButton))
						.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(message, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(sendButton, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
