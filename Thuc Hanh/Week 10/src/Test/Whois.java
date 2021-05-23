package Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
	public static void main(String args[]) throws Exception {
		int c;
		// Create a socket connected to internic.net, port 43.
		Socket s = new Socket("whois.internic.net", 43);
		// Obtain input and output streams.
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		// Construct a request string.
		String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";
		byte buf[] = str.getBytes(); // Convert to bytes.
		// Send request.
		out.write(buf);
		// Read and display response.
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
		s.close();
	}
}
