import java.util.Scanner;

public class ZohoArrayExample {

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
		//ZERO MUST BE IN THE STARTING OF AN ARRAY IF IT FOUND
		int i,j,temp=0,k=0;
		for(i=0;i<a.length;i++) {
			if(a[i]==0) {
				temp=a[i];
				a[i]=a[k];
				a[k]=temp;
				k++;
			}
			
			
	}
			for(i=0;i<a.length;i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		
	}

}
