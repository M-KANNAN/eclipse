import java.util.Scanner;

public class ArraySorting {

	public static void main(String[] args) {
		int a[]=new int[5];
		//GETTING INPUT FOR AN ARRAY
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the elements");
		for(int i=0;i<a.length;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}System.out.println();
		//SORTING AN ARRAY
		int i,j,temp=0;
		for(i=0;i<a.length;i++) {
		for(j=i+1;j<a.length;j++) {
		if(a[i]>a[j]) {
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		}
	}
		for( i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
		
		
		

	}

}
