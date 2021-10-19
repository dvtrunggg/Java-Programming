package Decorator;

import ComBase.ComDecorator;
import ComBase.ICom;

public class TrungSuon extends ComDecorator {

	public TrungSuon(ICom com1) {
		super(com1);
		// TODO Auto-generated constructor stub
	}

	public double Cost() {
		return 6 + super.Cost();
	}
}