
import java.util.Arrays;
import java.util.Scanner;

public class Qustion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
	
	//TRAVERSING ARRAY FROM RIGHT TO LEFT
		String s1=new String();
		System.out.println("Enter the number ");
		s1=scanner.next();
		
		//Splitting string with substring of function to store the number in arrar
		int arr[]=new int[s1.length()];
		for(int i=0;i<s1.length();i++) {
			arr[i]=Integer.parseInt(s1.substring(i, i+1));
		}
		
			System.out.println("ARRAY BEFORE : "+Arrays.toString(arr));
		
		
		//RIGHT MOST ELEMENT IS THE MAXIMUM ELEMENT FOR ASSUMPTION
		int len=arr.length;
		int max=arr[len-1];
		System.out.println("max"+max);
		
		//REVERSE LOOP FOR TRAVESING ARRAY FROM RIGHT TO LEFT
		// Initialize the next greatest element
		 
		  // The next greatest element for the rightmost element
		  // is always -1
		  arr[len-1] = 0;
		 
		  // Replace all other elements with the next greatest
		  for(int i = len-2; i >= 0; i--)
		  {
		    // Store the current element (needed later for updating
		    // the next greatest element)
		    int temp = arr[i];
		 
		    // Replace current element with the next greatest
		    arr[i] = max;
		 
		    // Update the greatest element, if needed
		    if(max< temp)
		       max= temp;
		  }
	
		System.out.println("ARRAY AFTER : " +Arrays.toString(arr));
		
	}

}
