package Training;

import java.util.Arrays;
import java.util.Scanner;

public class Program42 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of an array ");
		int len=scanner.nextInt();
		System.out.println("Enter the array elements ");
		int arr[]=new int[len];
		for(int i=0;i<len;i++) {
			arr[i]=scanner.nextInt();
		}
		  boolean visited[] = new boolean[arr.length];
		     
		    Arrays.fill(visited, false);
		 
		    // Traverse through array elements and
		    // count frequencies
		    int count = 1;
		    for (int i = 0; i < arr.length; i++) {
		 
		        // Skip this element if already processed
		        if (visited[i] == true)
		            continue;
		 
		        // Count frequency
		        	count=1;
		        for (int j = i + 1; j < arr.length; j++) {
		            if (arr[i] == arr[j]) {
		                visited[j] = true;
		                count++;
		            }
		        }
		        System.out.println(arr[i] + " count " + count);
		    }
		scanner.close();

	}

}
