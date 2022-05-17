package RailwayReservationSystem;

import java.util.Iterator;
import java.util.Scanner;

public class CancelTicket {

	Scanner scanner=new Scanner(System.in);
	public void cancelTicket() {
		
		System.out.println();
		System.out.println("****************");
		System.out.println("Welcome to login");
		System.out.println("---------------------------");
		System.out.println("Enter your customerId :");
		Long customerId=scanner.nextLong();
		System.out.println("Enter your mobile Number :");
		String mobileNo=scanner.next();
		
		UserSignUp details=UserSignUp.database.get(customerId);
		if(details != null && details.mobileNo.equals(mobileNo)) {
			UserSignUp deletedDeatils=UserSignUp.database.remove(customerId);
			System.out.println("Welcome to Cancel Ticket : "+deletedDeatils.name);
			TicketBooking  user=deletedDeatils.booking;
			System.out.println("Ticket number : "+user.seatNumber);
			String racTicketMover=user.seatNumber;
			String wlTicketMover=this.RACTicketMover(racTicketMover);
			if(wlTicketMover != null) {
				this.WLTicketMover(wlTicketMover);
			}
			
			
			System.out.println("Your Ticket cancelled successfully");
			System.out.println("**********************************");
			
		}
		else {
			System.out.println("!!! No user Found !!!");
		}
		
	}
	private void WLTicketMover(String wlTicketMover) {
		
		Iterator<Long> iterator=UserSignUp.database.keySet().iterator();
		while(iterator.hasNext()) {	
			Long costumerId=iterator.next();
			UserSignUp details=UserSignUp.database.get(costumerId);
			TicketBooking user=details.booking;
			if(user.bert == 'w' || user.bert == 'W' ) {
				user.seatNumber=wlTicketMover;
				user.status="RAC";
				user.bert=user.seatNumber.charAt(0);
				break;
			} 
		}

		
		
	}
	private String RACTicketMover(String seatNumber) {
		String seatNo = null;
		Iterator<Long> iterator=UserSignUp.database.keySet().iterator();
		while(iterator.hasNext()) {	
			Long costumerId=iterator.next();
			UserSignUp details=UserSignUp.database.get(costumerId);
			TicketBooking user=details.booking;
			if(user.bert == 'r' || user.bert == 'R' ) {
				seatNo=user.seatNumber;
				user.seatNumber=seatNumber;
				user.status="Confirm";
				user.bert=user.seatNumber.charAt(0);
				break;
			} 
		}
		return seatNo;
		
	}

}
