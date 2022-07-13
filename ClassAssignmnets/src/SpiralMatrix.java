import java.util.Scanner;

public class SpiralMatrix {

	static int i = -1, j = -1, num = 1, flag = 0;
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the matrix size: ");
		int matrixSize = scan.nextInt();
		System.out.println("----------------------------");
		System.out.println();
		arr = new int[matrixSize][matrixSize];

		try {
			while (flag < 3) {
				diagonalSteps();
				verticalSteps();
				horizontalSteps();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		displayArr(arr);
	}

	public static void diagonalSteps() {
		i++;
		j++;

		while (i < arr.length && j < arr[0].length) {
			if (arr[i][j] == 0) {
				flag = 0;
				arr[i++][j++] = num++;
			} else {
				i--;
				j--;
				break;
			}
		}

		if (i >= arr.length) {
			i = arr.length - 1; // array length decrease 
		}

		if (j >= arr[0].length) {
			j = (arr[0].length) - 1; // column size decreasing
		}

		flag++;
	}

	public static void horizontalSteps() {
		j--;

		while (j >= 0) {
			if (arr[i][j] == 0) {
				flag = 0;
				arr[i][j--] = num++;
			} else {
				j++;
				break;
			}
		}

		if (j < 0) {
			j = 0;
		}

		flag++;
	}

	public static void verticalSteps() {
		i--;

		while (i >= 0) {
			if (arr[i][j] == 0) {
				flag = 0;
				arr[i--][j] = num++;
			} else {
				i++;
				break;
			}
		}

		if (i < 0) {
			i = 0;
		}
		flag++;
	}

	public static void displayArr(int[][] arr) {
		for (int[] a : arr) {
			for (int b : a) {
				if (b != 0)
					System.out.print(b + "\t");
				else
					System.out.print("\t");
			}

			System.out.println();
		}
	}

}
