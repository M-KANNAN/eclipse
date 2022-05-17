import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len,i,j,temp=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the array length");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("enter the array elements");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();
			
		}
		//SIMPLE SORTING ALGORITHM 
		for(i=0;i<len;i++) {
			for(j=0;j<len;j++) {
				if(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("Array elements are");
		for(i=0;i<len;i++) {
			System.out.print(a[i]);
		}
	}

}
