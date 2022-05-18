package RailwayReservationSystem;

import java.util.Scanner;

public class Userlogin {
	Scanner scanner=new Scanner(System.in);

	public void userLogin() {
		
		System.out.println();
		System.out.println("****************");
		System.out.println("Welcome to login");
		System.out.println("----------------");
		System.out.println("Enter your customerId :");
		Long customerId=scanner.nextLong();
		System.out.println("Enter your mobile Number :");
		String mobileNo=scanner.next();
		
		UserSignUp details=UserSignUp.database.get(customerId);
		if(details != null && details.mobileNo.equals(mobileNo)) {
			System.out.println("Welcome to southern Railways "+details.name);
			new TicketBooking().ticketBooking(customerId);
		}
		else {
			System.out.println("!!! No user Found !!!");
		}
	}

}
