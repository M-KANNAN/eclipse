package fourte;

import java.util.Scanner;

public class ApplicationStart {

	private void flowManager() {
		Scanner scanner = new Scanner(System.in);

		boolean isExit = true;
		while (isExit) {
			System.out.println();
			System.out.println("\t\t\t FOURTE GAME");
			System.out.println();

			System.out.println("Enter your choice ");
			System.out.println("Enter 1 to simple problems");
			System.out.println("Enter 2 to complex problems");
			System.out.println("Enter 3 to exit");
			System.out.println();

			byte choice = scanner.nextByte();
			switch (choice) {
			case 1:
				new EasyGameModule().gameModule();
				break;

			case 2:
				new HardGameModule().gameModule();
				break;

			case 3:
				isExit = false;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

	public static void main(String[] args) {

		new ApplicationStart().flowManager();

	}

}
