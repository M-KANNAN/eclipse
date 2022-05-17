import java.util.Scanner;

public class LoginPage {
	
	String username;
	String password;
	Scanner scanner=new Scanner(System.in);
	public void loginPage() {
		System.out.println("----Welcome to user login-----");
		System.out.println("Enter the username : ");
		username=scanner.nextLine();
		System.out.println("Enter the password : ");
		password=scanner.nextLine();
		loginCheck(username,password);
	}
	private void loginCheck(String username, String password) {
		CreateAccount personaldetails=CreateAccount.database.get(username);
		if(personaldetails.name.equals(username)) {
			if(personaldetails.password.equals(password)) {
				System.out.println("------LOGIN SUCCESSFULL--------");
				new Userlogin().userLogin(username);
			}
			else {
				System.out.println("INVALID USER");
				this.loginPage();
			}
			
		}
		else {
			System.out.println("INVALID USER");
			this.loginPage();
			
		}
	}

}
