package Bank;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CreateAccount {
	
	String name;
	String mobile;
	static Long accountNumber =10000000001L;
	double balance;
	static LinkedHashMap<Long,CreateAccount> database=new LinkedHashMap<Long, CreateAccount>();
	
	Scanner scanner=new Scanner(System.in);
	

	public CreateAccount(long accountNumber, String name, String mobile, Double balance) {
		
		this.accountNumber=accountNumber;
		this.name=name;
		this.mobile=mobile;
		this.balance=balance;
	}


	public CreateAccount() {
		
	}


	public void createAccount() {
		
		byte i=1;
		while(i<4) {
			if (i == 1) {
				System.out.println("Your Account number : "+accountNumber);
				System.out.println("Enter your name : ");
				name=scanner.nextLine();
				i++;
			}
			else if (i == 2) {
				System.out.println("Enter your 10 digit mobile number :");
				mobile=scanner.next();
				if(mobile.length() == 10) {
					System.out.println("********************************");
					System.out.println("$$$ Account creates successfully $$$");
					i++;
				}
				else {
					i = 2;
				}
			}
			else if(i == 3) {
				CreateAccount account=new CreateAccount(accountNumber,name,mobile,balance);
				database.put(accountNumber,account);
				accountNumber++;
				i++;
			}
		}
		
	}

}
