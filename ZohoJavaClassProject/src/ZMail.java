import java.util.ArrayList;
import java.util.Scanner;

public class ZMail {
	Scanner scanner=new Scanner(System.in);
	
	ArrayList<String> userName=new ArrayList<String>();
	ArrayList<String> passWord=new ArrayList<String>();
	ArrayList<Object> obj=new ArrayList<Object>();
	
	ArrayList<String> allMail=new ArrayList<String>();
	ArrayList<String> MailId=new ArrayList<String>();
	
	byte userId;

	StringBuilder builder=new StringBuilder();
	
	
	private void mainMenu() {

		System.out.println("***********MAIN MENU*********");
		System.out.println("ENTER 1 to create Account"+"\n"+"Enter 2 to Login "+"\n"+"Enter 3 to Exit");
		short choice=scanner.nextByte();
		switch(choice) {
		  case 1 :{
			  this.createAccount();
			  break;
		  }
		  case 2 :{
			  this.userLogin();
			  break;
		  }
		  case 3 :{
			  break;
		  }
		  default : {
			  this.mainMenu();
			  break;
		  }
		}
		
	}

	private void userLogin() {
		int userIndex;
		String user="";
		String pass="";
		System.out.println("*************************************");
		System.out.println("*******Please login to your Email************");
		System.out.println("Enter the UserName :");
		user=scanner.next();
		if(userName.indexOf(user) != -1) {
			userIndex=userName.indexOf(user);
			System.out.println("Enter the Password :");
			pass=scanner.next();
			if(passWord.get(userIndex).equals(pass)) {
				System.out.println("*******WELCOME******"+user+" *********");
				this.loginMenu(userIndex);
			}
			else {
				System.out.println("User not found");
				System.out.println("*****************");
				this.mainMenu();
			}
			
		}
		else {
			System.out.println("User not found");
			System.out.println("*****************");
			this.mainMenu();
		}
		
	}

	private void createAccount() {
		System.out.println("*************************************");
		System.out.println("Enter the UserName :");
		builder.append(scanner.next());
		if(userName.contains(builder.toString())) {
			System.out.println("Already a user found please enter a new username");
			this.mainMenu();
		}
		else {
			userName.add(builder.toString());
			System.out.println("Enter the Password :");
			passWord.add(scanner.next());
			System.out.println("User Created Successfully");
			userId++;
			System.out.println("Your user id : "+userId);
			obj.add(userId);
			System.out.println("*************************************");
			builder.delete(0, builder.length());
			this.mainMenu();
			
			
		}
		
		
	}

	private void loginMenu(int userIndex) {
		System.out.println("***********LOGIN MENU*********");
		System.out.println("ENTER 1 to compose"+"\n"+"Enter 2 to list all mail "+"\n"+"Enter 3 to delete mail "+"\n"+"Enter 4 to Exit");
		short choice=scanner.nextByte();
		switch(choice) {
			case 1 :{
				this.composeMail(userIndex);
				break;
			}
			case 2 :{
				this.viewMail(userIndex);
				break;
			}
			case 3:{
				this.deleteMail(userIndex);
				break;
			}
			case 4:{
				break;
			}
			default :{
				break;
			}
		}
		
	}

	private void deleteMail(int userId) {
		// TODO Auto-generated method stub
		System.out.print("Enter the mailId of the mail to be deleted");
		byte mailId=scanner.nextByte();
		allMail.remove(mailId);
		this.loginMenu(userId);
		
	}

	private void viewMail(int userIndex) {
		// TODO Auto-generated method stub
		allMail.add("Hello1");
		allMail.add("Hello2");
		allMail.add("Hello3");
		allMail.add("Hello4");
		allMail.add("Hello5");
		System.out.println(allMail);
		this.loginMenu(userIndex);
		
		
	}

	private void composeMail(int userIndex) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		
		ZMail mail=new ZMail();
		mail.mainMenu();
	}	

}
