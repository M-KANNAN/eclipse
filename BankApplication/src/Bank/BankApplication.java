package Bank;

import java.util.Scanner;

public class BankApplication {
	
	
	private static void main() {
		Scanner scanner=new Scanner(System.in);
		
		boolean isExite=true;
		while(isExite) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("-----WELCOME TO NATIONAL BANK--------");
			System.out.println();
			System.out.println("Enter 1 for Create Account : ");
			System.out.println("Enter 2 for Login");
			System.out.println("Enter 3 to Exit");
			byte choice=scanner.nextByte();
			switch(choice){
				case 1 :{
					new CreateAccount().createAccount();
					break;
				}
				case 2 :{
					new LoigIn().userlogin();
					break;
				}
				case 3 :{
					isExite=false;
					break;
				}
			}
			
		}
		
	}


	public static void main(String[] args) {
		main();

	}

	
}
