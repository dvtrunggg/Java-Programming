package SinhVien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainTest {

	public static void main(String[] args) throws ParseException {
		
//		//show database
		studentList stl = new studentList();
//		stl.findAll();
//
//		System.out.println("------------");
//		stl.Output();
		
		
		String sDate = "1990/12/11";
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate);

		Student st2 = new Student(1222, "Chu Chi Nhuoc", date, "TPHCM");
		st2.Output();

		//insert
		stl.Insert(st2);
		stl.findAll();
		System.out.println("--------------");
		st2.Output();
//
//		delete theo id
//		stl.Delete(111);
//		stl.findAll();
//		System.out.println("--------------");
//		st2.Output();
//
//		//delete theo doi tuong
//		stl.Delete(st2);
//		stl.findAll();
//		st2.Output();
//
//		//update
//		stl.Update(111, 111, "Hoang Dung", "1998/2/3", "Quang Dong");
//		stl.findAll();
//		st2.Output();
//
//		//search theo id
//		stl.SearchByID(1001);
//		
//		//search theo ten
//		stl.SearchByName("Hoang Dung");

	}
}
