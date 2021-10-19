package NoDecorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

/**
 * 
 * @author trung Encryption and read, write file
 *
 */
public class EncryptionFileData extends DataSource {

	public EncryptionFileData(String d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	public void writeData(String data, String fName) {
		File file = new File(fName);
		try (OutputStream fos = new FileOutputStream(file)) {
			fos.write(data.getBytes(), 0, data.length());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String readData(String fName) {
		char[] buffer = null;
		File file = new File(fName);
		try (FileReader reader = new FileReader(file)) {
			buffer = new char[(int) file.length()];
			reader.read(buffer);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return new String(buffer);
	}
	
	public String encode(String data) {
		byte[] result = data.getBytes();
		for (int i = 0; i < result.length; i++) {
			result[i] += (byte) 1;
		}
		return Base64.getEncoder().encodeToString(result);
	}

	public String decode(String data) {
		byte[] result = Base64.getDecoder().decode(data);
		for (int i = 0; i < result.length; i++) {
			result[i] -= (byte) 1;
		}
		return new String(result);
	}

	public String compress(String stringData) {
		return null;
	};
	
	public String decompress(String stringData) {
		return null;
	};

}
