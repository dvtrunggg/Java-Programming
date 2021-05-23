package test;

public class exercise2 {
//	public static boolean estP(String str) {
//		int i = 0;
//		int j = str.length() - 1;
//
//		try {
//			while (i != j && str.charAt(i) == str.charAt(j)) {
//				i++;
//				j--;
//			}
//		} catch (IndexOutOfBoundsException e) {
//			System.out.println("ahhi" + e.getMessage());
//		}
//
//		return (i == j);
//	}

	// i = 0, j = str.length() - 1
//	public static boolean estP(String str, int i, int j) {
//		
//		if (i + 1 == str.length()/2) {
//			estP(str, i + 1, j);
//			return (i == j);
//		}
//		else
//			return (i == j);
//		if (str.charAt(i) == str.charAt(j)) {
//			estP(str, i + 1, j - 1);
//		}
//	}

//	public static boolean estP(String str, int i, int j) {
//		if (str.charAt(i) != str.charAt(j))
//			return false;
//		
//	}

//	public static boolean estP(String str) {
//		if(str.length() == 0 || str.length() == 1)
//			return true;
//		if(str.charAt(0) == str.charAt(str.length() - 1))
//			estP(str.substring(1));
//		return false;
//	}
	
	public static void main(String[] args) {
		String str = "abba";
//		System.out.println(estP(str, 0, str.length() - 1));
		if(estP(str))
			System.out.print("True");
		else
			System.out.print("False");
	}
}
