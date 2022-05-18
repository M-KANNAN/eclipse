package RailwayReservationSystem;

import java.util.Iterator;

public class TicketDetails {

	public void tickectDetails() {
		
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("-------Booked tickets--------");
		System.out.println("************************************");
		System.out.println();
		
		Iterator<Long> iterator=UserSignUp.database.keySet().iterator();
		while(iterator.hasNext()) {
			
			Long costumerId=iterator.next();
			UserSignUp details=UserSignUp.database.get(costumerId);
			TicketBooking user=details.booking;
			if(user.seatNumber != null) {
				System.out.println("Passenger Id : "+costumerId);
				System.out.println("Passanger name : "+details.name);
				System.out.println("Passanger age : "+details.age);
				System.out.println("Passenger mobile no : "+details.mobileNo);
				System.out.println("Passenger berth : "+user.bert);
				System.out.println("Passenger ticket number : "+user.seatNumber);
				System.out.println("Ticket status :"+user.status);
				System.out.println("***************************");
				System.out.println();
			} 
		

		}
		
		
	}

}
