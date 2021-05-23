package Exercise2;

/* CLIENT */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	private InetAddress host;
	private int port;

	public Client(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}

	public void Execute() throws IOException {
		// entrer nom
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.nextLine();

		Socket client = new Socket(host, port);
		ReadClient read = new ReadClient(client);
		read.start();
		WriteClient write = new WriteClient(client, name);
		write.start();

	}
	
	public static void main(String[] args) throws IOException {
		int port = 1000;
		Client cl = new Client(InetAddress.getLocalHost(), port);
		cl.Execute();
	}
	
}

//read data
class ReadClient extends Thread {
	private Socket client;

	public ReadClient(Socket socket) {
		this.client = socket;
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(client.getInputStream());
			while (true) {
				String sms = dis.readUTF();
				System.out.println(sms);
			}
		} catch (Exception e) {
			try {
				dis.close();
				client.close();
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println("I/O error " + e2);
			}
		}
	}

}

//write data
class WriteClient extends Thread {
	private Socket client;
	private String name;

	public WriteClient(Socket socket, String name) {
		this.client = socket;
		this.name = name;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataOutputStream dos = null;
		Scanner sc = null;
		{
			try {
				dos = new DataOutputStream(client.getOutputStream());
				sc = new Scanner(System.in);
				while (true) {
					String sms = sc.nextLine();
					dos.writeUTF(name + ": " + sms);
				}
			} catch (Exception e) {
				// TODO: handle exception
				try {
					dos.close();
					client.close();
				} catch (Exception e2) {
					System.out.println("I/O error " + e2);
				}
			}
		}
	}
}