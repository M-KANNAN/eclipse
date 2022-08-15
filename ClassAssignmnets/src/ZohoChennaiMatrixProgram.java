
import java.util.Scanner;

public class ZohoChennaiMatrixProgram {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the matrix size: ");
		int maxLength = scanner.nextInt();
		int arr[][] = new int[maxLength][maxLength];

		System.out.println("Enter a array elements");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		System.out.println("Enter the size to which the matrix to be reduced ");
		int reduceSize = scanner.nextInt();

		if (reduceSize > arr.length) { 
			System.out.println("!!! Not possible !!!");
		} else {
			topRowAdder(arr, reduceSize);
		}

	}

	private static void topRowAdder(int[][] arr, int reduceSize) {

		int toprowAdderArray[][] = new int[arr.length - 1][arr.length];

		for (int i = 0; i < toprowAdderArray.length; i++) {
			for (int j = 0; j < toprowAdderArray[0].length; j++) {
				if (i == 0) {
					toprowAdderArray[i][j] = arr[i][j] + arr[arr.length - 1][j];
				} 
//				else if (i != arr.length - 1) {
//					
//				} 
				else {
					toprowAdderArray[i][j] = arr[i][j];
					//break;
				}
			}
		}
		
		leftColumnAdder(toprowAdderArray, reduceSize);

		System.out.println("Row : " + toprowAdderArray.length + " " + toprowAdderArray[0].length);

		if (toprowAdderArray.length == reduceSize  &&  toprowAdderArray[0].length == reduceSize) {
			matrixViewer(toprowAdderArray);
		} 
		else if (toprowAdderArray.length < reduceSize) {
			System.out.println("!!! Not possible !!!");
		}
		else {
			leftColumnAdder(toprowAdderArray, reduceSize);
		}

	}

	private static void leftColumnAdder(int[][] arr, int reduceSize) {

		int leftColumnAdderArray[][] = new int[arr.length][arr[0].length - 1];

		for (int i = 0; i < leftColumnAdderArray.length; i++) {
			for (int j = 0; j < leftColumnAdderArray[0].length; j++) {
				if (j == 0) {
					leftColumnAdderArray[i][j] = arr[i][j] + arr[i][arr[0].length - 1];
				} 
//				else if (j != arr[0].length - 1) {
//					leftColumnAdderArray[i][j] = arr[i][j]; //
//				}
				else {
					
					leftColumnAdderArray[i][j] = arr[i][j];
//					break;

				}
			}
		}
		
		matrixViewer(leftColumnAdderArray);

		System.out.println("Row : " + leftColumnAdderArray.length + " " + "column : " + leftColumnAdderArray[0].length);

		if (leftColumnAdderArray.length == reduceSize && leftColumnAdderArray[0].length == reduceSize ) {
			matrixViewer(leftColumnAdderArray);
		} 
		else if (leftColumnAdderArray.length < reduceSize  &&  leftColumnAdderArray[0].length < reduceSize) {
			System.out.println("!!! Not possible !!!");
		} 
		else {
			// matrixViewer(leftColumnAdderArray);
			 bottomRowAdder(leftColumnAdderArray,reduceSize);

		}

	}

	private static void bottomRowAdder(int[][] arr, int reduceSize) {

		int bottomRowAdderArray[][] = new int[arr.length - 1][arr.length];

		for (int i = 0; i < bottomRowAdderArray.length; i++) {
			for (int j = 0; j < bottomRowAdderArray[0].length; j++) {
				if (i == arr.length - 1) {
					bottomRowAdderArray[i][j] = arr[i][j] + arr[0][j];
				} 
//					else if (i != 0) {
//					bottomRowAdderArray[i][j] = arr[i][j];
//				} 
				else {
					bottomRowAdderArray[i][j] = arr[i][j];
					//break;
				}
			}
		}
		
		matrixViewer(bottomRowAdderArray);

		System.out.println("Row : " + bottomRowAdderArray.length + " " + bottomRowAdderArray[0].length);

		if (bottomRowAdderArray.length == reduceSize &&  bottomRowAdderArray[0].length == reduceSize) {
			matrixViewer(bottomRowAdderArray);
		}
		else if (bottomRowAdderArray.length < reduceSize) {
			System.out.println("!!! Not possible !!!");
		} 
		else {
			rightColumnAdder(bottomRowAdderArray, reduceSize);
		}

	}

	private static void rightColumnAdder(int[][] arr, int reduceSize) {
		
		int rightColumnAdderArray[][] = new int[arr.length][arr[0].length - 1];

		for (int i = 0; i < rightColumnAdderArray.length; i++) {
			for (int j = 0; j < rightColumnAdderArray[0].length; j++) {
				if (j == arr[0].length - 1) {
					rightColumnAdderArray[i][j] = arr[i][j] + arr[i][0];
				} 
//				else if (j != 0) {
//					rightColumnAdderArray[i][j] = arr[i][j]; //
//				} 
				else {
					
					rightColumnAdderArray[i][j] = arr[i][j];
					//break;

				}
			}
		}

		matrixViewer(rightColumnAdderArray);
		
		System.out.println("Row : " + rightColumnAdderArray.length + " " + "column : " +rightColumnAdderArray[0].length);

		if (rightColumnAdderArray.length == reduceSize  &&  rightColumnAdderArray[0].length == reduceSize) {
			matrixViewer(rightColumnAdderArray);
		} else if (rightColumnAdderArray.length < reduceSize) {
			System.out.println("!!! Not possible !!!");
		} else {
			// matrixViewer(leftColumnAdderArray);
			 topRowAdder(rightColumnAdderArray,reduceSize);

		}
		
	}

	private static void matrixViewer(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
