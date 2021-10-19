package NoDecorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

public class EncryptionData extends DataSource {

	public EncryptionData(String d) {
		super(d);
		// TODO Auto-generated constructor stub
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
	public void writeData(String data, String fName) {
		//nothing here
	}

	public String readData(String fName) {
		return null;
	}


}