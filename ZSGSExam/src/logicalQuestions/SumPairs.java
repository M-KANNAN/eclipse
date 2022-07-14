package logicalQuestions;
import java.util.Scanner;

public class SumPairs {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a size of an array");
		int len = scanner.nextInt();
		int arr[] = new int[len];
		System.out.println("Enter a array elements : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println("Enter a sum value");
		int k = scanner.nextInt();

		sumPairFiner(arr, k);
		scanner.close();

	}

	private static void sumPairFiner(int[] arr, int k) {

		int temp[]=new int[arr.length];
		int index=0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) % k == 0) {
					boolean flag=true;
					for(int m=0;m<temp.length;m++) {
						if(temp[m] == arr[i]) {
							flag=false;
							break;
						}
					}
					
					if (flag) {
						temp[index++] =arr[i];
						//temp[++index] =arr[i];
						System.out.print("[ " + arr[i] + " , " + arr[j] + " ]");
					}
				}

			}
		}

	}

}
