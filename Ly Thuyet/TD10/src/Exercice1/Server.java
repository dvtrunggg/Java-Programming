package Exercice1;

/* SERVER – may enhance to work for multiple clients */
import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket client;

		// Default port number we are going to use
		int portnumber = 1111;
		if (args.length >= 1) {
			portnumber = Integer.parseInt(args[0]);
		}

		// Create Server side socket
		try {
			server = new ServerSocket(portnumber);
		} catch (IOException ie) {
			System.out.println("Cannot open socket." + ie);
			System.exit(1);
		}
		System.out.println("ServerSocket is created " + server);

		// Wait for the data from the client and reply
		while (true) {

			try {

				// Listens for a connection to be made to
				// this socket and accepts it. The method blocks until
				// a connection is made
				System.out.println("Waiting for connect request...");
				client = server.accept();

				System.out.println("Connect request is accepted...");
				String clientHost = client.getInetAddress().getHostAddress();
				int clientPort = client.getPort();
				System.out.println("Client host = " + clientHost + " Client port = " + clientPort);

				// Read data from the client
				InputStream clientIn = client.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
				String msgFromClient = br.readLine();
				System.out.println("Message received from client:  " + msgFromClient);
				System.out.println();

				// Send response to the client
				boolean checkBonjour = msgFromClient.toLowerCase().contains("bonjour, je m'appelle ");

				if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye") && checkBonjour) {

					OutputStream clientOut = client.getOutputStream();
					PrintWriter pw = new PrintWriter(clientOut, true);

					// split string
					String subStr[] = msgFromClient.split(" ");

					String ansMsg = "Bonjour, " + subStr[subStr.length - 1];

					pw.println(ansMsg);
				}

				// Close sockets
				if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {

					OutputStream clientOut = client.getOutputStream();
					PrintWriter pw = new PrintWriter(clientOut, true);

					String ansMsg = "Byeee";
					pw.println(ansMsg);
					server.close();
					client.close();
					break;
				} else {
					OutputStream clientOut = client.getOutputStream();
					PrintWriter pw = new PrintWriter(clientOut, true);

					String ansMsg = "J'ai recu ce message de: " + msgFromClient;
					pw.println(ansMsg);
				}

			} catch (IOException ie) {
			}
		}
	}
}