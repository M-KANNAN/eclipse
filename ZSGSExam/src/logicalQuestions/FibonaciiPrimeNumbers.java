package logicalQuestions;

public class FibonaciiPrimeNumbers {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		fibonaciiPrimeNumber(num1, num2);

	}

	private static void fibonaciiPrimeNumber(int num1, int num2) {

		int arr[]=new int[10];
		int count=0;
		
		while (count < 10) {
			int num3 = num1 + num2;
			boolean flag = true;
			

			if (num3 > 1) {

				for (int i = 2; i <= (int) Math.sqrt(num3); i++) {
					if (num3 % i == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arr[count++]=num3;
				}
				num1 = num2;
				num2 = num3;
			}
			else {
				num1 = num2;
				num2 = num3;
			}

			
		}
		for (int obj : arr) {
			System.out.print(obj + " ");
		}

	}

}
