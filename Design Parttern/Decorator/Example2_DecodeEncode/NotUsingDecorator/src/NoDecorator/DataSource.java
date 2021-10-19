package NoDecorator;

public abstract class DataSource {
	protected String data;

	public DataSource(String d) {
		data = d;
	}

	abstract void writeData(String data, String fName);

	abstract String readData(String fName);

	abstract String encode(String data);

	abstract String decode(String data);

	abstract String compress(String stringData);

	abstract String decompress(String stringData);
}
