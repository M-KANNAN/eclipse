import java.util.Scanner;

public class TwistedPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner  scanner=new Scanner(System.in);
		System.out.println("Enter a number :");
		int num=scanner.nextInt();
		new TwistedPrime().functionLogic(num);
		
		
	
		scanner.close();

	}

	private void functionLogic(int num) {
		// TODO Auto-generated method stub
		int reverse=0;
		boolean flag=true;
		
		for(int i=2;i<Math.abs(Math.sqrt(num));i++) {
			if(num % i == 0) {
				flag=false;
				break;
			}
		}
		
		if(flag == true) {
			while(num > 0) {
				reverse=reverse*10+num%10;
				num/=10;
			}
			
			for(int i=2;i<Math.abs(Math.sqrt(reverse));i++) {
				if(reverse % i == 0) {
					flag=false;
					break;
				}
			}
			
			
		}
		System.out.println(flag==true ? "Twisted prime" : "Not a Twisted Prime" );
		
	}

}
