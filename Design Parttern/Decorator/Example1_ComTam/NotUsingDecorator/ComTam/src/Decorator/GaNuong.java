package Decorator;

import ComBase.ComDecorator;
import ComBase.ICom;

public class GaNuong extends ComDecorator {

	public GaNuong(ICom com1) {
		super(com1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double Cost() {
		return 8 + super.Cost();
	}
}