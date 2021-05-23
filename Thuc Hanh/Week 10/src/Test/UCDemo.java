package Test;

import java.io.InputStream;
import java.net.*;
import java.util.Date;

public class UCDemo {
	public static void main(String args[]) throws Exception {
		int c;
		URL hp = new URL("http://www.internic.net");
		URLConnection hpCon = hp.openConnection();
		long d = hpCon.getDate(); // get date
		if (d == 0)
			System.out.println("No date information.");
		else
			System.out.println("Date: " + new Date(d));
		// get content type
		System.out.println("Content-Type: " + hpCon.getContentType());
		System.out.println("---------------------------");
		d = hpCon.getExpiration(); // get expiration date
		if (d == 0) {
			System.out.println("No expiration information.");
			System.out.println("---------------------------");
		}

		else {
			System.out.println("Expires: " + new Date(d));
			System.out.println("---------------------------");
		}

		// get last-modified date
		d = hpCon.getLastModified();
		if (d == 0) {
			System.out.println("No last-modified information.");
			System.out.println("---------------------------");
		} else {
			System.out.println("Last-Modified: " + new Date(d));
			System.out.println("---------------------------");
		}
		// get content length
		long len = hpCon.getContentLengthLong();
		if (len == -1)
			System.out.println("Content length unavailable.");
		else
			System.out.println("Content-Length: " + len);

		if (len != 0) {
			System.out.println("=== Content ===");
			InputStream input = hpCon.getInputStream();
			while (((c = input.read()) != -1)) {
				System.out.print((char) c);
			}
			input.close();
		} else {
			System.out.println("No content available.");
		}
	}
}
