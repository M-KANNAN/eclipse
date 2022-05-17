import java.util.Scanner;

public class DuplicateArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i,j,len;
		System.out.println("Enter the size of the array:");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("Enter the array elements:");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();
		}
		//checking process
		for(i=0;i<len;i++) {
		for(j=i+1;j<len;j++) {
			if(a[j]==a[i]) {
				System.out.println("Duplicate element is "+a[i]);
			}
		}
		}
		
		

	}		

}
