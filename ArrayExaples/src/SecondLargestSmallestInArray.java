import java.util.Scanner;

public class SecondLargestSmallestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize 2 variables for each
		int largest=0,secondLargest=0;
		int smallest=Integer.MAX_VALUE,secondSmallest=Integer.MAX_VALUE;
		Scanner scanner=new Scanner(System.in);
		int i,len;
		System.out.println("Enter the array length");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("Enter the array elements");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();
		}
		//2nd LARGEST ELEMENT IN A ARRAY
		for(i=0;i<len;i++) {
			if(a[i]>largest) {
				secondLargest=largest;
				largest=a[i];
			}
			else if (a[i]>secondLargest){
				secondLargest=a[i];
				
			}
			
		}
		//2nd SMALLEST ELEMENT IN A ARRAY
		for(i=0;i<len;i++) {
			
			if (a[i]<smallest){
				secondSmallest=smallest;
				smallest=a[i];
			}
			else if(a[i]<secondSmallest) {
				secondSmallest=a[i];
			}
			
		}
		
		
		
		System.out.println(largest);
		System.out.println(secondLargest);
		System.out.println(smallest);
		System.out.println(secondSmallest);
	
	}

}
