package RailwayReservationSystem;

import java.util.Scanner;

public class ApplicationStart {
	
	private void flowManager() {
		
		Scanner  scanner=new Scanner(System.in);
		
		boolean isExit=true;
		byte choice;
		while(isExit) {
			System.out.println("        ---------------------------");
			System.out.println("        Welcome to SouthernRailways     ");
			System.out.println("        ***************************");
			
			System.out.println();
			System.out.print("Train Number   :  54213");
			System.out.print("          Train Name : NellaiExpress");
			System.out.println();
			System.out.print("Starting Point : Nellai");
			System.out.print("          Boarding Point : Chennai");
			System.out.println();
			System.out.println("        ***************************");
			
			System.out.println("Enter your choice");
			System.out.println(" 1.Signup");
			System.out.println(" 2.Login");
			System.out.println(" 3.Cancel ticket");
			System.out.println(" 4.Booking details");
			System.out.println(" 5.Exit");
			choice=scanner.nextByte();
			switch(choice) {
				case 1 :{
					new UserSignUp().userSignUp();
					break;
				}
				case 2 :{
					new Userlogin().userLogin();
					break;
				}
				case 3 :{
					new CancelTicket().cancelTicket();
					break;
				}
				case 4 : {
					new TicketDetails().tickectDetails();
					break;
				}
				case 5 :{
					isExit=false;
					System.out.println("!!! THANK YOU !!!");
					break;
				}
			}
		}
		scanner.close();
		
	}
	

	public static void main(String[] args) {
		ApplicationStart applicationStart=new ApplicationStart();
		applicationStart.flowManager();

	}

	

}
