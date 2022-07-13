
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSeriesAndPrime {
	
	
	private void fibonacciSeries(int len) {
		int n1=0;
		int n2=1;
		int n3=0;
		ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(0,1));
		while(len > 1) {
			n3=n1+n2;
			arrayList.add(n3);
			n1=n2;
			n2=n3;
			
			boolean flag=true;
			for(int i=2;i<n3;i++) {
				if(n3 % i == 0) {
					flag=false;
					break;
				}
			}
			if(flag == true) {
				System.out.print(n3+" ");
				len--;
			}
			
			
		}
		System.out.println();
		System.out.println("Series "+arrayList);
		
		
	}


	public static void main(String[] args) {
		
		Scanner  scanner=new Scanner(System.in);
		System.out.println("Enter the length to which found the series");
		int len=scanner.nextInt();
		//System.out.print(0+" "+1);
		new FibonacciSeriesAndPrime().fibonacciSeries(len);
		

	}

	
}
