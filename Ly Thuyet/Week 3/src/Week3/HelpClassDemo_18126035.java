package Week3;

import java.util.Scanner;

class Help_18126035{
	void helpOn(int what)
	{
		switch (what) {
		case '1':
			System.out.println("\nThe if: \n\t if(condition) \n\t\t statement; \n\t else \n\t\t statement;");
			break;
		case '2':
			System.out.println("\nThe switch: \nswitch(expression){");
			System.out.println("\t case constant: \n\t\t statement sequence \n\t\t break;");
			System.out.println("\t// ...\n}");
			break;
		case '3':
			System.out.println("\nThe for:");
			System.out.println("for(init; condition; iteration){");
			System.out.println("\t statement; \n...");
			break;

		case '4':
			System.out.println("\nThe while: ");
			System.out.println("while(condition){" + "\n\t statement; \n}");
			break;
		case '5':
			System.out.println("\nThe do ... while:");
			System.out.println("do {\n\t statement;");
			System.out.println("} while (condition);");
			break;
		case '6':
			System.out.println("\nbreak label;");
			System.out.println("\tlabel est le nom d'une étiquette qui identifie un bloc de code.");

			break;
		case '7':
			System.out.println("\ncontinue label;");
			System.out.println("\tlabel est le nom d'une étiquette qui identifie un bloc de code.");
			break;
		case 'q':
			System.out.println("\nSuccessfully Quit");
			break;

		default:
			System.out.println("\nSelection not found.");
		}
	}
	
	void showMenu()
	{
		System.out.println("Help on: \n\t 1. if \n\t 2. switch");
		System.out.println("\t 3. for");
		System.out.println("\t 4. while");
		System.out.println("\t 5. do ... while");
		System.out.println("\t 6. break");
		System.out.println("\t 7. continue");
		System.out.print("Choose one( q to quit): ");
	}
	
	boolean isValid(int choice) 
	{
		if (choice >= 1 && choice <= 7)
			return true;
		else
			return false;
		
	}
}

public class HelpClassDemo_18126035 {
	
	
	public static void main(String[] args) throws java.io.IOException {
		int choice;
		Help_18126035 help = new Help_18126035();
		char temp;
		Scanner sc1 = new Scanner(System.in);
		do {
			help.showMenu();
			//choice = (int)System.in.read() - '0';
			choice = sc1.nextInt();
			
			do {
				temp = (char) System.in.read();
			} while (temp != '\n');
			
			if (help.isValid(choice))
				help.helpOn(choice);
			else
				System.out.println("Not valid");
			

		} while (help.isValid(choice));


		
	}
	
}
