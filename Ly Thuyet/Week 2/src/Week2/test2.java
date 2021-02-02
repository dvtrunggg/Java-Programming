package Week2;

public class test2 {
	public static String ConvertBoolToString(boolean p, boolean q) {
		String value_p, value_q;
		value_p = (p ? "1" : "0");
		value_q = (q ? "1" : "0");
		return value_p + "\t" + value_q + "\t";
	}

	public static String LogicDec(boolean and, boolean or, boolean xor, boolean not) {
		String value_and, value_or, value_xor, value_not;
		value_and = (and ? "1" : "0");
		value_or = (or ? "1" : "0");
		value_xor = (xor ? "1" : "0");
		value_not = (not ? "1" : "0");
		return value_and + "\t" + value_or + "\t" + value_xor + "\t" + value_not;
	}

	public static String Display(boolean p, boolean q) {
		return ConvertBoolToString(p, q) + LogicDec(p & q, p | q, p ^ q, !p);
	}

	public static Boolean Check(int number) {
		if (number == 0)
			return false;
		return true;
	}

	public static String DisplayCharacter(boolean p, boolean q) {
		return p + "\t" + q + "\t" + (p & q) + "\t" + (p | q) + "\t" + (p ^ q) + "\t" + !p;
	}

	public static void Display() {
		System.out.println("P\tQ\tAnd\tOr\tXor\tNot");
		for (int i = 1; i >= 0; i--) {
			for (int j = 1; j >= 0; j--) {
				System.out.println(Display(Check(i), Check(j)));
			}
		}

		System.out.println("-----------------------------------------");

		System.out.println("P\tQ\tAnd\tOr\tXor\tNot");
		for (int i = 1; i >= 0; i--) {
			for (int j = 1; j >= 0; j--) {
				System.out.println(DisplayCharacter(Check(i), Check(j)));
			}
		}
	}

	public static void main(String[] args) throws java.io.IOException {
		char index_1 = 'a', index = 'a', ignore;
		do {
			System.out.print("1. Logical Dec Table\n2. Help On\n\tChoose One(q to quit): ");
			index_1 = (char) System.in.read();
			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
			switch (index_1) {
			case '1':
				Display();
				break;
			case '2':
				do {
					System.out.println("Help On");
					System.out.println("\t1. if");
					System.out.println("\t2. switch");
					System.out.println("\t3. for");
					System.out.println("\t4. while");
					System.out.println("\t5. do...while");
					System.out.println("\t6. break");
					System.out.println("\t7. continue");
					System.out.print("Choose one (q to quit): ");
					index = (char) System.in.read();
					do {
						ignore = (char) System.in.read();
					} while (ignore != '\n');

					switch (index) {
					case '1':
						System.out.println("The if: \n\tif(condition) statement \n\t else statement");
						break;
					case '2':
						System.out.println(
								"The switch: \nswitch(expression){\n\tcase constant:\n\t\tstatement sequence\n\t\tbreak;\n\t//...\n}");
						break;
					case '3':
						System.out.println("The for: \n\tor(init; condition; iteration){\n\tstatement; \n}\n..");
						break;
					case '4':
						System.out.println("The while: \nwhile(condition) statement\n..");
						break;
					case '5':
						System.out.println("The do..while:\ndo{\n\tstatement;\n}while(condition)\n..");
						break;
					case '6':
						System.out.println("\t Label: BREAK");
						break;
					case '7':
						System.out.println("\t Label: Continue");
						break;
					default:
						System.out.println("Selection not found!");
						break;
					}
				} while (index != 'q');
				break;
			default:
				System.out.println("Selection not found!");
			}
		} while (index_1 != 'q');

	}
}
