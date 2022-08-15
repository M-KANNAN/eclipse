package fourte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HardGameModule {

	public void gameModule() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Hard  Level ");
		System.out.println();

		System.out.println("Sample output");
		System.out.println("form a equation for this value : 6");
		System.out.println("Equation like : 4	3	6	4  as (3+4)-(6-4)");
		System.out.println("by inserting proper in the given number spaces operators +,-,*,/,(,)");

		boolean isExit = true;
		while (isExit) {
			System.out.println();
			System.out.println("Enter yor choice");
			System.out.println("Enter 1 to play");
			System.out.println("Enter 2 to quit");
			byte choice = scanner.nextByte();
			switch (choice) {
			case 1:
				String equation = equationGenerator();
				this.fourteHardMode(equation);
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

	private void fourteHardMode(String equation) {

		Scanner scanner = new Scanner(System.in);
		System.out.println();
		String arr[] = equation.split("=");
		System.out.println("CONSTRUCT THE EQUATION FOR THE OUPUT");

		System.out.println(arr[1]);

		System.out.println("Form a equation from these number" + arr[0]);

		ArrayList<String> arrayList = new ArrayList<>();

		for (int i = 0; i < arr[0].length(); i++) {
			if (Character.isDigit(arr[0].charAt(i))) {
				arrayList.add(String.valueOf(arr[0].charAt(i)));
			}
		}

		Collections.shuffle(arrayList);

		for (String character : arrayList) {
			System.out.print(character + "\t");
		}

		String userEquation = FourteLogics.getUserEquationForHarderModule(arrayList);

		if (arr[0].equals(userEquation)) {
			System.out.println("!!! Correct Option !!!");
		} else {

			String leftString = userEquation.substring(1, 4);
			String rightString = userEquation.substring(7, 10);

			// System.out.println(s1 + " "+s2);

			int leftResult = FourteLogics.resultfinder(leftString);
			int rightResult = FourteLogics.resultfinder(rightString);

			System.out.println(leftResult + " " + rightResult);

			int result = userEquation.charAt(5) == '+' ? (leftResult + rightResult)
					: userEquation.charAt(5) == '-' ? (leftResult - rightResult)
							: userEquation.charAt(5) == '*' ? (leftResult * rightResult) : (leftResult / rightResult);

			System.out.println(result == Integer.parseInt(arr[1]) ? "CORRECT EQUATION" : "!!! OOPS WRONG !!!");

			System.out.println(result == Integer.parseInt(arr[1]) ? userEquation : equation);

		}

	}

	private String equationGenerator() {

		StringBuilder equBuilder = new StringBuilder();

		char SymbolArray[] = { '0', '*', '+', '-', '/' };

		char randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];

		while (true) {
			if (randomSymbol == '0') {
				randomSymbol = SymbolArray[(int) (Math.random() * (4)) + 1];
			} else {
				break;
			}
		}
		

		String leftPart = FourteLogics.logicalFunction();
		String rightPart = FourteLogics.logicalFunction();

		while (true) { // unique number aciveing index out off

			if (leftPart.length() == rightPart.length()) { // if length not equal change both string
				boolean flag = true;
				for (int i = 0; i < leftPart.length(); i++) {
					if (Character.isDigit(leftPart.charAt(i))) {
						if (rightPart.contains(String.valueOf(leftPart.charAt(i)))) { // if repetation of character
																						// change right string alone
							flag = false;
							break;
						}
					}
				}
				if (flag) {
					break;
				} else {
					rightPart = FourteLogics.logicalFunction();
				}
			} else {
				leftPart = FourteLogics.logicalFunction();
				rightPart = FourteLogics.logicalFunction();
			}

		}

		// non zero output

		String leftPartArray[] = leftPart.split("=");
		String rightPartArray[] = rightPart.split("=");

		// System.out.println(Arrays.toString(leftPart)+" "+Arrays.toString(rightPart));
		int leftResult = Integer.parseInt(leftPartArray[1]);
		int rightResult = Integer.parseInt(rightPartArray[1]);

		int result = randomSymbol == '+' ? (leftResult + rightResult)
				: randomSymbol == '-' ? (leftResult - rightResult)
						: randomSymbol == '*' ? (leftResult * rightResult) : (leftResult / rightResult);
		//non zero result
		
		if(result < 0) {
			this.equationGenerator();
		}
		

		equBuilder.append("(" + leftPartArray[0] + ")" + randomSymbol + "(" + rightPartArray[0] + ")=" + result);

		return equBuilder.toString();
	}

}
