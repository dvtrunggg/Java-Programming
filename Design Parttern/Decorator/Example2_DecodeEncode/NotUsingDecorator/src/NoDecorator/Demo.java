package NoDecorator;

public class Demo {
	public static void main(String[] args) {
		String salaryRecords = "trungggggg";
		
		//encode 
		DataSource ds;
		ds = new EncryptionData(salaryRecords);
		String endcode = ds.encode(salaryRecords);
		
		System.out.println(endcode);
		
		//------------------------------------------
		
		//compress data
		DataSource ds2;
		ds2 = new CompressionData(salaryRecords);
		String compress = ds2.compress(salaryRecords);
		System.out.println(compress);
		
		//encode and write file
		DataSource ds3;
		ds3 = new EncryptionData(salaryRecords);
		String endcode2 = ds.encode(salaryRecords + "Trung agian:)");
		ds3.writeData(endcode2, "OutputDemo2.txt");
	}
}
