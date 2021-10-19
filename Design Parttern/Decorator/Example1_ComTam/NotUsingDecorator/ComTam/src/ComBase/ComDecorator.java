package ComBase;

public class ComDecorator implements ICom {
	protected ICom comm;
	
	public ComDecorator(ICom com1) {
		comm = com1;
	}
	
	@Override
	public double Cost() {
		return this.comm.Cost();
	}
}
