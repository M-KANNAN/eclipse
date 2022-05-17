import java.util.LinkedHashMap;
import java.util.Scanner;

public class CreateAccount {
	
	String name;
	String mobile;
	String password;
	LinkedHashMap mails;
	LinkedHashMap sendMails;
	static LinkedHashMap<String, CreateAccount> database=new LinkedHashMap<String, CreateAccount>();
	
	Scanner scanner=new Scanner(System.in);
	

	public CreateAccount(String name, String mobile, String password, LinkedHashMap mails,
			LinkedHashMap sendMails) {
	
		this.name=name;
		this.mobile=mobile;
		this.password=password;
		this.mails=mails;
		this.sendMails=sendMails;
		
	}

	public CreateAccount() {
		
	}

	public void createAccount() {
		
		System.out.println("--------Welcome to userlogin--------");
		int i=1;
		while(i<=4) {
			if(i ==1 ) {
				System.out.println("Enter the Username :");
				name=scanner.nextLine();
				i++;
			}
			else if(i == 2){
				System.out.println("Enter the 10 digit mobile number :");
				mobile=scanner.nextLine();
				if(mobile.length() == 10) {
					i++;
				}
				else {
					i=2;
				}
			}
			else if(i == 3) {
				System.out.println("Enter the password : ");
				password=scanner.nextLine();
				i++;
			}
			else if(i == 4) {
				mails=new LinkedHashMap<Integer, Mails>();
				sendMails=new LinkedHashMap<Integer, Mails>();
				CreateAccount personalAccount=new CreateAccount(name,mobile,password,mails,sendMails);
				database.put(name, personalAccount);
				System.out.println("---------ACOUNT CREATEd SUCCESSFULLY-------");
				System.out.println("-------THANK YOU !!!---------");
				i++;
			}
			
		}
		
	}

}
