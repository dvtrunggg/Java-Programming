package Main;

import ComBase.Com;
import ComBase.ComDecorator;
import ComBase.ICom;
import Decorator.GaNuong;
import Decorator.ThitChien;
import Decorator.TrungSuon;

public class Main {
	public static void main(String[] args) {
		ICom com1 = new GaNuong(new ThitChien(new TrungSuon(new Com())));
		System.out.println("Com Thit Chien Ga Nuong Trung Suon: " + com1.Cost());
		
		ICom com2 = new GaNuong(new TrungSuon(new Com()));
		System.out.println("Com Ga Nuong Trung Suon: " + com2.Cost());
		
		ICom com3 = new GaNuong(new Com());
		System.out.println("Com Ga Nuong: " + com3.Cost());

	}
}
