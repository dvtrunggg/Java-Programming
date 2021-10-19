package Decorator;

import ComBase.ComDecorator;
import ComBase.ICom;

public class ThitChien extends ComDecorator {

	public ThitChien(ICom com1) {
		super(com1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double Cost() {
		return 10 + super.Cost();
	}
}
