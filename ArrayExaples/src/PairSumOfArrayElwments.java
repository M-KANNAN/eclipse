import java.util.Scanner;

public class PairSumOfArrayElwments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int i,j,sum=0,len,x;
		System.out.println("Enter the array size");
		len=scanner.nextInt();
		int a[]=new int[len];
		System.out.println("Enter the array elements");
		for(i=0;i<len;i++) {
			a[i]=scanner.nextInt();
		}
		System.out.println("Enter the sum elemenmt to be checked");
		x=scanner.nextInt();
		for(i=0;i<len;i++) {
			for(j=i+1;j<len;j++) {
				if(a[i]+a[j]==x) {
					System.out.println("Pair of "+a[i]+" and"+a[j]+" produce the sum as given value "+ x);
				}
				
			}
		}
		
		

	}

}
