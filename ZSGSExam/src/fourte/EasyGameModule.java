package fourte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EasyGameModule {

	public void gameModule() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to easy Level ");
		System.out.println();

		System.out.println("Sample output");
		System.out.println("form a equation for this value : 5");
		System.out.println("Form a equation like : 1*5");
		System.out.println("Using a numbers  1 to 8 with operators +,-,*,/");

		boolean isExit = true;
		while (isExit) {
			System.out.println();
			System.out.println("Enter yor choice");
			System.out.println("Enter 1 to play");
			System.out.println("Enter 2 to quit");
			byte choice = scanner.nextByte();
			switch (choice) {
			case 1:
				String equation = FourteLogics.logicalFunction();
				this.fourteEasyMode(equation);
				break;
			case 2:
				isExit = false;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

		}

	}

	private void fourteEasyMode(String equation) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		String arr[] = equation.split("=");
		System.out.println("CONSTRUCT THE EQUATION FOR THE OUPUT");

		System.out.println(arr[1]);

		System.out.println("Form a equation from these numbers");

		System.out.print((int) (Math.random() * 6) + 1 + "\t");

		ArrayList<String> arrayList = new ArrayList<>();

		for (int i = 0; i < arr[0].length(); i++) {
			if (Character.isDigit(arr[0].charAt(i))) {
				arrayList.add(String.valueOf(arr[0].charAt(i)));
			}
		}

		while (true) {
			int randomNumber = FourteLogics.randomGenerator();
			if (arrayList.size() < 3) {
				if (!arrayList.contains(String.valueOf(randomNumber))) {
					arrayList.add(String.valueOf(randomNumber));
				}
			} else {
				break;
			}

		}

		Collections.shuffle(arrayList);

		for (String character : arrayList) {
			System.out.print(character + "\t");
		}

		String userEquation = "";


		int result = FourteLogics.resultfinder(userEquation);

		// check logic

		System.out.println(result == Integer.parseInt(arr[1]) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");
		System.out.println(result == Integer.parseInt(arr[1]) ? userEquation : equation);

		// System.out.println(arr[1]);

	}

}