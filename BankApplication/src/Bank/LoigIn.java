package Bank;

import java.util.Scanner;

public class LoigIn {
	Scanner scanner=new Scanner(System.in);
	public void userlogin() {
		
		byte i = 1;
		while(i < 2) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("--------Userlogin---------");
			System.out.println("Enter the account number:");
			long accountNumber=scanner.nextLong();
			System.out.println("Enter mobile number :");
			String mobile=scanner.next();
			CreateAccount details=CreateAccount.database.get(accountNumber);
			if(i == 1) {
				if(details != null && details.mobile.equals(mobile)) {
					
						System.out.println("$$$$$$$$$Loged in Successfully$$$$$$$$$$");
						this.transcationPage(accountNumber);
						i++;
				}
				else {
					System.out.println("----!!!!Invalid User!!!!---");
					i++;
				}
				
			}
			
				
		}
		
	}

	private void transcationPage(long accountNumber) {
		boolean isExit=true;

		while(isExit) {
			System.out.println("*************************************");
			System.out.println("$$$$$$$Welcome to transcation$$$$$$$$");
			System.out.println("Enter 1 to balance Enquiry :");
			System.out.println("Enter 2 to Deposite balance :");
			System.out.println("Enter 3 to Withdraw balance : ");
			System.out.println("Enter 4 to transfer money : ");
			System.out.println("Enter 5 to Logout");
			byte choice =scanner.nextByte();
			switch(choice) {
				case 1 :{
					new UserTransaction().balanceEnquiry(accountNumber);
					break;
				}
				case 2 :{
					new UserTransaction().balanceDeposite(accountNumber);
					break;
				}
				case 3 :{
					new UserTransaction().balanceWithdraw(accountNumber);
					break;
				}
				case 4 :{
					new UserTransaction().moneyTransfer(accountNumber);
					break;
				}
				case 5 :{
					isExit=false;
					break;
				}
			}
		}
		
	}

}
