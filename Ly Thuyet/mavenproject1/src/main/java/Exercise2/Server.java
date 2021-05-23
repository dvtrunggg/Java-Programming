package Exercise2;


/* SERVER  may enhance to work for multiple clients */
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Server {

	private InetAddress host;
	private int port;
	public static ArrayList<Socket> listSK = new ArrayList<>();

	public Server(InetAddress host, int port) {
		this.host = host;
		this.port = port;
	}

	public Server(int port) {
		this.port = port;
	}

	public void Execute() throws IOException {
		ServerSocket sv = new ServerSocket(port);

		WriteServer write = new WriteServer();
		write.start();
		while (true) {
			Socket socket = sv.accept();
			System.out.println("Connected " + socket);
			Server.listSK.add(socket);
			ReadServer read = new ReadServer(socket);
			read.start();
		}

	}

	public static void main(String[] args) throws IOException {
		int port = 10000;
		if (args.length >= 1) {
			port = Integer.parseInt(args[0]);
		}
		Server.listSK = new ArrayList<>();
		Server sv = new Server(port);
		sv.Execute();
	}

}

//read data
class ReadServer extends Thread {
	private Socket server;

	public ReadServer(Socket socket) {
		this.server = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(server.getInputStream());
			while (true) {

				String sms = dis.readUTF();
//				if (sms.contains("exit")) {
//
//					System.out.println("Da ngat ket noi");
//					dis.close();
//					server.close();
//					continue; // ngat ket noi
//				}

				for (Socket i : Server.listSK) {
					if (i.getPort() != server.getPort()) {
						DataOutputStream dos = new DataOutputStream(i.getOutputStream());
						dos.writeUTF(sms);
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			try {
				// dis.close();
				server.close();
			} catch (IOException e2) {
				// TODO: handle exception
				System.out.println("I/O error " + e2);
			}
		}
	}

}

//write data
class WriteServer extends Thread {
	// private Socket server;
	//
	// public WriteServer(Socket socket) {
	// this.server = socket;
	// }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			String sms = sc.nextLine();
			try {
				for (Socket i : Server.listSK) {
					dos = new DataOutputStream(i.getOutputStream());
					dos.writeUTF("Server: " + sms);
					
					if(i.isClosed()) {
						dos.writeUTF("hihi");
					}
				}
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println("I/O error " + e);

			}
		}
	}
}