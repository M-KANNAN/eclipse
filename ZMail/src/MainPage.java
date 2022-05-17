import java.util.Scanner;

public class MainPage {
	public static void main() {
		int i=0;
		while(i<2) {
			System.out.println("-------WELCOME TO MAIL------");
			System.out.println("*****************************");
			System.out.println("Enter 1 to create new Account");
			System.out.println("Enter 2 to login");
			System.out.println("Enter 3 to Exit");
			Scanner scanner=new Scanner(System.in);
			byte choice;
			try {
				choice=scanner.nextByte();
				switch(choice) {
					case 1 :{
						new CreateAccount().createAccount();
						i=1;
						break;
					}
					case 2 :{
						new LoginPage().loginPage();
						i=1;
						break;
					}
					case 3 :{
						System.out.println("-------THANK YOU-------");
						i=i+2;
						break;
					}
				}
				
			} catch (Exception e) {
				System.out.print("Enter the valid choice !!!");
				MainPage.main();
				
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		main();
		
		

	}

}
