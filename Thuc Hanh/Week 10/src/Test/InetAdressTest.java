package Test;

import java.net.*;

class InetAdressTest {
	public static void main(String args[]) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		address = InetAddress.getByName("www.vnexpress.net");
		System.out.println(address);
		InetAddress SW[] = InetAddress.getAllByName("www.hcmus.edu.vn");
		for (int i = 0; i < SW.length; i++)
			System.out.println(SW[i]);

	}
}