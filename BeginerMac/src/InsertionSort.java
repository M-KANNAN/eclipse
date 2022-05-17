import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the lenght of an array");
			int len=scanner.nextInt();
			int a[]=new int[len];
			System.out.println(System.in);
			for(int k=0;k<len;k++) {
				a[k]=scanner.nextInt();
			}
			for(int k=1;k<len;k++) {
				int temp=a[k];
				int j=k-1;
				while(j>=0&&temp<=a[j]) {
					a[j+1]=a[j];
					j=j-1;	
				}
				a[j+1]=temp;
			}
        for(int j=0;j<len;j++) {
			System.out.print(a[j]);
}
		}
		
		catch(Exception e) {
			System.out.println(e);
		}

	}
	

}
