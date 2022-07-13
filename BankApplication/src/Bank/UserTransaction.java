package Bank;

import java.util.Scanner;

public class UserTransaction {

	Scanner scanner=new Scanner(System.in);

	public void balanceEnquiry(long accountNumber) {
		
		CreateAccount details=CreateAccount.database.get(accountNumber);
		System.out.println("Welcome "+details.name+" your account balance is : "+details.balance);
		
	}

	public void balanceDeposite(long accountNumber) {
		
		CreateAccount details=CreateAccount.database.get(accountNumber);
		System.out.println("Welcome "+details.name);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Enter the amount to be deposited :");
		double moneyDeposite=scanner.nextDouble();
		if(moneyDeposite <= 0 ) {
			System.out.println("!!! INVALID-DEPOSITE !!!");
			//this.balanceDeposite(accountNumber);
		}
		else {
			details.balance+=moneyDeposite;
			System.out.println("$$$$Deposited Sucessfull$$$$");
			System.out.println("****************************");
		}	
	}

	public void moneyTransfer(long accountNumber) {
		CreateAccount senderDetails=CreateAccount.database.get(accountNumber);
		System.out.println("Welcome "+senderDetails.name);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Enter the Amount to be transferd :");
		double moneyTransfer=scanner.nextDouble();

		if(moneyTransfer >=0 && moneyTransfer < senderDetails.balance) {
			System.out.println("Enter the Account number for transfer :");
			long transferAcountnumber=scanner.nextLong();
			CreateAccount reciverDetails=CreateAccount.database.get(transferAcountnumber);
			if(reciverDetails != null) {
				reciverDetails.balance=reciverDetails.balance+moneyTransfer;
				senderDetails.balance=senderDetails.balance-moneyTransfer;
				System.out.println("$$$$Transfer Sucessfull$$$$");
				System.out.println("****************************");
			}
			else {
				System.out.println("!!!INCORRECT ACCOUNT NUMBER !!!!");
			}
		}
		else {
			System.out.println("Transfer limit Exceeds !!!!");
		}
		
	}

	public void balanceWithdraw(long accountNumber) {
		CreateAccount details=CreateAccount.database.get(accountNumber);
		System.out.println("Welcome "+details.name);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Enter the amount to be withdraw :");
		double moneyWithdraw=scanner.nextDouble();
		if(moneyWithdraw <=0 && moneyWithdraw > details.balance) {
			System.out.println("!!! Withdraw-Invaild !!!");
			//this.balanceWithdraw(accountNumber);
		}
		else {
			moneyWithdraw=details.balance-moneyWithdraw;
			details.balance=moneyWithdraw;
			System.out.println("$$$$Withdraw Sucessfull$$$$");
			System.out.println("****************************");
		}
		
	}

	

}
