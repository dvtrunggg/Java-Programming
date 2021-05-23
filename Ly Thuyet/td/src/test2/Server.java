package test2;

import java.io.*;
import java.util.*;
import java.net.*;
  
public class Server extends Thread {
	private static ArrayList<BufferedWriter> clients;
	private static ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream in; 
    private InputStreamReader inr; 
    private BufferedReader bfr;
    private String name;
    
    public Server(Socket clientSocket) {
    	this.clientSocket = clientSocket;
    	try {
			in = clientSocket.getInputStream();
			inr = new InputStreamReader(in);
			bfr = new BufferedReader(inr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    public void run() {
    	try {
    		String msg;
			OutputStream out = this.clientSocket.getOutputStream();
			Writer outWriter = new OutputStreamWriter(out);
			BufferedWriter bfw = new BufferedWriter(outWriter);
			clients.add(bfw);
			name = msg = bfr.readLine();
			while(!"Logout".equalsIgnoreCase(msg) && msg != null) { 
				msg = bfr.readLine(); 
				sendToAll(bfw, msg); 
				System.out.println(msg); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private void sendToAll(BufferedWriter bfw, String msg) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw;
		for (BufferedWriter buffer : clients) {
			bw = buffer;
			if (!(bfw == bw)) {
				bw.write(name + ": " + msg + "\r\n");
				bw.flush();
			}
		}
	}
	
	public static void main(String []args) {
		try {
			serverSocket = new ServerSocket(8080);
			clients = new ArrayList<BufferedWriter>();
			
			while(true) {
				System.out.print("Waiting for connection...\n");
				Socket clientSocket = serverSocket.accept();
				System.out.print("Client connected...\n");
				Thread t = new Server(clientSocket);
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}