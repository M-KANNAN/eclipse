import java.util.Scanner;

public class RemoveDuplicateItemInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i,len,x,j;
		System.out.println("Enter the size of an array:");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("Enter the array elements");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();			
		}
		for(i=0;i<len;i++) {
			for(j=i+1;j<len;j++) {
				if(a[i]==a[j]) {
					//DUPLICATE ELEMENT IS REMOVED AND NEXT ELEMENT IS MOVED TO THE Jth PLACE
					a[j]=a[j+1];
					//LENGTH OF THE ARRAY MUST BE DECREASED BECAUSE THE ELEMEMT IS REMOVED 
					len=len-1;
					j=j-1;
				}
			}
		}
		System.out.println("Array elements are");
		for(i=0;i<len;i++) {
			System.out.println(a[i]);
		}

	}

}
