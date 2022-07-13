
import java.util.Scanner;

public class ZigZagPattern {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a size of an matix");
		int len = scanner.nextInt();
		System.out.println("Enter a array elements : ");
		int[][] arr = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		new ZigZagPattern().functionalLogic(arr);

	}

	private void functionalLogic(int[][] arr) {

//		for (int i = 0; i <= arr.length + 1; i++) { // akka logic
//			for (int j = 0; j < arr.length; j++) {
//				for (int k = 0; k < arr.length; k++) {
//					if (j + k == i) {
//						System.out.println(j + " " + k + " " + (j + k));
//						// System.out.print(arr[j][k] + "\t");
//					}
//				}
//			}
//		}
		
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[j][i] +" \t");
			}
			System.out.println();
		}

	}

}
