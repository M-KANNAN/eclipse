package RailwayReservationSystem;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class UserSignUp {
	
	
	String name;
	String mobileNo;
	byte age;
	char bertPreferences;
	TicketBooking booking;
	static Long customerID=1000000000001L;
	static LinkedHashMap<Long, UserSignUp> database=new LinkedHashMap<Long, UserSignUp>();
	Scanner scanner=new Scanner(System.in);
	
	
	public UserSignUp(String name, byte age, char bertPreferences, TicketBooking booking,String mobileNo) {
		this.name=name;
		this.age=age;
		this.bertPreferences=bertPreferences;
		this.booking=booking;
		this.mobileNo=mobileNo;
	}


	public UserSignUp() {
		
	}


	public void userSignUp() {
		byte i=1;
		boolean isexit=true;
		System.out.println("---------------------------");
		System.out.println("Welcome to userlogin");
		System.out.println("***************************");
		while(isexit) {
			if(i == 1){
				System.out.println("Your CustomerId : "+customerID);
				System.out.println("Enter your name ");
				name=scanner.next();	
				i++;
				}
			else if (i == 2) {
				System.out.println("Enter your age");
				age=scanner.nextByte();
				i++;
			}
			else if(i == 3) {
				System.out.println("Enter your mobile Number ");
				mobileNo=scanner.next();
				if(mobileNo.length() == 10) {
					i++;
				}
				else {
					i=1;
				}
	
				i++;
				System.out.println();
				isexit=false;
			}
			
		}
		
		
		booking=new TicketBooking();
		UserSignUp login=new UserSignUp(name,age,bertPreferences,booking,mobileNo);
		database.put(customerID, login);
		customerID++;

	}

}
