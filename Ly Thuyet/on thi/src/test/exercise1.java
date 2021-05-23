package test;

class X {
	static int count = 0;
	int a;

	public X(int i) {
		a = i;
		count++;
	}

	long getMagic(int f) {
		return a * f;
	}

	long getMatric(long f) {
		return 2 * a * f;
	}
}

class Y extends X {
	public Y(int i) {
		super(i);
	}

	long getMagic(byte f) {
		return 4 * a * f;
	}
}

public class exercise1 {
	public static void main(String[] args) {
		X o1 = new X(5);
		X o2 = new Y(5);
		Y o3 = new Y(5);
		byte value = 50;
		
		System.out.println("o1: "+o1.getMagic(value));
		System.out.println("o2: "+o2.getMatric((long)value));
		System.out.println("o2: "+o3.getMagic(value));
		
		System.out.println(X.count);
		System.out.println(Y.count);
	}
}
