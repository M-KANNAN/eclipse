import java.util.Scanner;

public class TailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number :");
		int n=scanner.nextInt();
		int count=0;
		
		while(n>0) {
			n/=5;
			//System.out.println("n ="+n);
			count+=n;
			//System.out.println("Count ="+count);
		}
		System.out.println(count);

	}

}
