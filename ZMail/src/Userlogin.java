import java.util.Scanner;

public class Userlogin {
	Scanner scanner=new Scanner(System.in);
	void userLogin(String userName) {
		int i=1;
		while(i < 2) {
			
			System.out.println("Enter 1 to compose a mail :");
			System.out.println("Enter 2 for view mails : ");
			System.out.println("Enter 3 for view sentmails :");
			System.out.println("Enter 4 for delete mail :");
			System.out.println("Enter 5 to Logout :");
			
			byte choice=scanner.nextByte();
			if(choice == 1) {
			    new Mails().composeMail(userName);
			}
			else if(choice == 2) {
				new Mails().viewMail(userName);
			}
			else if(choice == 3) {
				new  Mails().viewSentMail(userName);
			}
			else if(choice == 4) {
				new Mails().deleteMail(userName);
			}
			else if(choice == 5) {
				i++;
			}
			
		}
	}
}
