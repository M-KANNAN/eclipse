import java.util.Scanner;

public class KthLargestSmallestInArray {
	//USING SORTING

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WRONG METHOD
		Scanner scanner = new Scanner(System.in);
		int i, j, len, max, min, count = 0, k;
		System.out.println("Enter the length of an array");
		len = scanner.nextInt();
		int a[] = new int[len];
		System.out.println("Enter the array elements");
		for (i = 0; i < len; i++) {
			a[i] = scanner.nextInt();
		}
		// ARRAY MUST BE SORTED TO FIND THE MAXIMUM OR MINIMUM
		for (i = 0; i < len; i++) {
			for (j = i + 1; j < len; j++) {
				if (a[i] > a[j]) {
					int temp;
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;

				}
			}
		}
		System.out.println("Ente the Kth value");
		k = scanner.nextInt();
		max=0;
		min=Integer.MAX_VALUE;
		for(i=0;i<len;i++) {
			if(a[i]<min) {
				min=a[i];
				count++;
				if(count<=k) {
					System.out.println("MINIMUM ELEMENT OF ARRAY IS "+min);
					break;
				}
			}
		}
		for(i=0;i<len;i++) {
			if(a[i]>max) {
				max=a[i];
				count++;
				if(count<=k) {
					System.out.println("Maximum ELEMENT OF ARRAY IS "+max);
					break;
				}
			}
		}
		

	}
}
