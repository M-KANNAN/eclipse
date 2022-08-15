package fourte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FourteLogics {

	public static String logicalFunction() {

		char SymbolArray[] = { '0', '*', '+', '-', '/' };
		StringBuilder equationFormation = new StringBuilder();

		int randomNumber1 = randomGenerator();
		int randomNumber2 = randomGenerator();

		char randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];

		while (true) { // to achive multiplication

			if (randomSymbol == '0') {
				randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];
			} else {
				break;
			}
		}

		while (true) { // for division and subtraction number1 > number 2 change number2

			if ((randomSymbol == '/' || randomSymbol == '-') && randomNumber1 < randomNumber2) {
				randomNumber1 = randomGenerator();
				randomNumber2 = randomGenerator();
			} else {
				break;
			}
		}

		while (true) { // division rule change number2

			if ((randomSymbol == '/' && randomNumber1 % randomNumber2 == 0)) {
				randomNumber1 = randomGenerator();
				randomNumber2 = randomGenerator();
			} else {
				break;
			}
		}
		int result = 0;
		while (true) {

			result = resultfinder(randomNumber1 + "" + randomSymbol + "" + randomNumber2);
			if (result != 0) {
				break;
			} else {
				randomNumber1 = randomGenerator();
				randomNumber2 = randomGenerator();
			}
		}

		equationFormation.append(randomNumber1 + "" + randomSymbol + "" + randomNumber2 + "=" + result);

		return equationFormation.toString();

	}

	public static int resultfinder(String userEquation) {

		if (userEquation.contains("+")) {
			return Integer.parseInt(String.valueOf(userEquation.charAt(0)))
					+ Integer.parseInt(String.valueOf(userEquation.charAt(2)));
		} else if (userEquation.contains("-")) {
			return Integer.parseInt(String.valueOf(userEquation.charAt(0)))
					- Integer.parseInt(String.valueOf(userEquation.charAt(2)));
		} else if (userEquation.contains("*")) {
			return Integer.parseInt(String.valueOf(userEquation.charAt(0)))
					* Integer.parseInt(String.valueOf(userEquation.charAt(2)));
		} else {
			return Integer.parseInt(String.valueOf(userEquation.charAt(0)))
					/ Integer.parseInt(String.valueOf(userEquation.charAt(2)));
		}

	}

	public static int randomGenerator() {

		int max = 8;
		int min = 1;
		int range = max - min + 1;

		return ((int) (Math.random() * range) + min);
	}

	public static String getUserEquationForHarderModule(ArrayList<String> arrayList) {
		Scanner scanner = new Scanner(System.in);
		String userEquation = "";
//		while (true) {
//			userEquation = scanner.nextLine();
//			boolean flag = true;
//			for (int i = 0; i < userEquation.length(); i++) {
//				if (Character.isDigit(userEquation.charAt(i))) { // digits only check
//					if (!arrayList.contains(String.valueOf(userEquation.charAt(i))) || (userEquation
//							.indexOf(userEquation.charAt(i)) != userEquation.lastIndexOf(userEquation.charAt(i)))) {// same digits as given as choice
//						System.out.println("!!! only given values are accepted");
//						System.out.println("Enter again");
//						System.out.println(); 
//						flag = false;
//						break;
//					}
//				}
//
//			}
//			if (flag) {
//				break;
//			}
//		}

		ArrayList<String> arrayList2 = new ArrayList<String>(); //temp arraylist for unique value acheiving

		while (true) {
			userEquation = scanner.nextLine();
			for (int i = 0; i < userEquation.length(); i++) {
				if (Character.isDigit(userEquation.charAt(i))) {
					arrayList2.add(String.valueOf(userEquation.charAt(i)));
				}
			}
			Collections.sort(arrayList);
			Collections.sort(arrayList2);
			if (arrayList.equals(arrayList2)) {
				break;
			} else {
				arrayList2.clear();
				System.out.println("!!! only given values are accepted");
				System.out.println("Enter again");
				System.out.println();
			}
		}

		return userEquation;

	}

}
