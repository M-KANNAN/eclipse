package RailwayReservationSystem;

import java.util.Scanner;

public class TicketBooking {
	
	protected static byte lowerBerth=1;
	protected static byte middleBerth=1;
	protected static byte upperBerth=1;
	protected static byte RAC=1;
	protected static byte waitingList=1;
	
	
	Scanner scanner=new Scanner(System.in);
	char bert;
	String seatNumber;
	String status;
 
	public TicketBooking(char bert,byte ticketNo) {
		this.bert=bert;
		this.seatNumber=(bert+""+ticketNo).toUpperCase();
		if( bert == 'U' || bert == 'M' || bert == 'L') {//
			this.status="CONFIRM";
		}
		else if(bert == 'r') {
			this.status="RAC";
		}
		else {
			this.status="WAITING LIST";
		}
	}

	public TicketBooking() {
		
	}

	public void ticketBooking(Long costumerId) {	
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		
		System.out.println("*************************");
		System.out.println("Welcome to ticket booking "+details.name);
		System.out.println();
		System.out.println("Available tickets :");
		System.out.println("Lower Berth :"+( 1 - TicketBooking.lowerBerth + 1));
		System.out.println("Middle Berth :"+(1 - TicketBooking.middleBerth + 1));
		System.out.println("Upper Berth :"+(1 - TicketBooking.upperBerth + 1));
		
		System.out.println("Enter your bert preference :");
		System.out.println("u for upperBerth");
		System.out.println("l for lowerBerth");
		System.out.println("m for middleBerth");
		
		char bertPreferences=scanner.next().charAt(0);
		if(bertPreferences == 'l' || bertPreferences == 'L' ) {
			
			if( TicketBooking.lowerBerth <= 1 && TicketBooking.lowerBerth > 0) {
				this.lowerBerthConfermation(costumerId,'L',lowerBerth);
			}
			else if( TicketBooking.middleBerth <= 1 && TicketBooking.middleBerth > 0) {
				this.middleBerthConfermation(costumerId,'M',middleBerth);
			}
			else if(TicketBooking.upperBerth <= 1 && TicketBooking.upperBerth > 0) {
				this.upperBerthConfermation(costumerId,'U',upperBerth);
			}
			else if(TicketBooking.RAC <= 1 && TicketBooking.RAC > 0) {
				this.racBerthConfermation(costumerId,'R',RAC);
			}
			else if(TicketBooking.waitingList <= 1 && TicketBooking.waitingList > 0) {
				this.wlBerthConfermation(costumerId,'W',waitingList);
			}
			else {
				System.out.println("!!! Ticket Unavailable !!!");
			}
			
			
		}
		else if(bertPreferences == 'm' || bertPreferences == 'M'){
			
			
			if(TicketBooking.middleBerth <= 1 && TicketBooking.middleBerth > 0) {
				this.middleBerthConfermation(costumerId,'M',middleBerth);
			}
			else if( TicketBooking.lowerBerth <= 1 && TicketBooking.lowerBerth > 0) {
				this.lowerBerthConfermation(costumerId,'L',lowerBerth);
			}
			
			else if(TicketBooking.upperBerth<= 1 && TicketBooking.upperBerth > 0) {
				this.upperBerthConfermation(costumerId,'U',upperBerth);
			}
			else if(TicketBooking.RAC <= 1 && TicketBooking.RAC > 0) {
				this.racBerthConfermation(costumerId,'R',RAC);
			}
			else if(TicketBooking.waitingList <= 1 && TicketBooking.waitingList > 0) {
				this.wlBerthConfermation(costumerId,'W',waitingList);
			}
			else {
				System.out.println("!!! Ticket Unavailable !!!");
			}
			
			
			
		}
		else if(bertPreferences == 'u' || bertPreferences == 'U' ) {
			
			if(TicketBooking.upperBerth <= 1 && TicketBooking.upperBerth > 0) {
				this.upperBerthConfermation(costumerId,'U',upperBerth);
			}
			else if(TicketBooking.middleBerth<= 1 && TicketBooking.middleBerth > 0) {
				this.middleBerthConfermation(costumerId,'M',middleBerth);
			}
			else if( TicketBooking.lowerBerth <= 1 && TicketBooking.lowerBerth > 0) {
				this.lowerBerthConfermation(costumerId,'L',lowerBerth);
			}
			else if(TicketBooking.RAC <= 1 && TicketBooking.RAC > 0) {
				this.racBerthConfermation(costumerId,'R',RAC);
			}
			else if(TicketBooking.waitingList <= 1 && TicketBooking.waitingList > 0) {
				this.wlBerthConfermation(costumerId,'W',waitingList);
			}
			else {
				System.out.println("!!! Ticket Unavailable !!!");
			}
			
			
		}
		
	}

	private void wlBerthConfermation(Long costumerId, char bertPreferences, byte waitingList) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		user=new TicketBooking('w',waitingList);
		details.booking=user;
		this.waitingList++;
		this.detailsPrinting(costumerId);
		
	}

	private void racBerthConfermation(Long costumerId, char bertPreferences, byte RAC) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		user=new TicketBooking('r',RAC);
		details.booking=user;
		this.RAC++;
		this.detailsPrinting(costumerId);
		
		
	}

	private void upperBerthConfermation(Long costumerId, char bertPreferences, byte upperBerth) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		user=new TicketBooking(bertPreferences,upperBerth);
		details.booking=user;
		this.upperBerth++;
		this.detailsPrinting(costumerId);
		
		
	}

	private void middleBerthConfermation(Long costumerId, char bertPreferences, byte middleBerth) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		user=new TicketBooking(bertPreferences,middleBerth);
		details.booking=user;
		this.middleBerth++;
		this.detailsPrinting(costumerId);
		
	}

	private void lowerBerthConfermation(Long costumerId, char bertPreferences, byte lowerBerth) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		user=new TicketBooking(bertPreferences,lowerBerth);
		details.booking=user;
		this.lowerBerth++;
		this.detailsPrinting(costumerId);
		
	}

	private void detailsPrinting(Long costumerId) {
		UserSignUp details=UserSignUp.database.get(costumerId);
		TicketBooking user=details.booking;
		System.out.println();
		System.out.println("*************************");
		System.out.println("***TICKET DETAILS***");
		System.out.println("-------------------------");
		System.out.println("");
		System.out.println(details.name);
		System.out.println("Berth : "+user.bert);
		System.out.println("Ticket no : "+user.seatNumber);
		System.out.println("Ticket status :"+user.status);
		System.out.println("!!! THANK YOU !!! ");
		System.out.println();
	}

}
