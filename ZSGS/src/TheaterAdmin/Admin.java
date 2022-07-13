package TheaterAdmin;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Admin {

	static LinkedHashMap<String, LinkedHashMap<String, String>> theaterDatabase = new LinkedHashMap<String, LinkedHashMap<String,String>>();
	
	public void movieAlter() {
		
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println();
		System.out.println("Vefify you admin status");
		System.out.println();
		String userName=scanner.nextLine();
		System.out.println("Enter Your password ");
		String password=scanner.nextLine();
		
		if(userName.equals("Admin") && password.equals("Admin")) {
			System.out.println();
			System.out.println("Enter you choice ");
			System.out.println("1 to change English movie ");
			System.out.println("2 to change tamil movie");
			byte choice=scanner.nextByte();
			
			if(choice == 1) {
				System.out.println();
				System.out.println("Enter 1 to change screen 1");
				System.out.println("Enter 2 to change screen 2");
				byte choice1=scanner.nextByte();
				if(choice1 == 1) {
					System.out.println("Enter a movie to be played in screen 1 ");
					scanner.nextLine();
					String movieName=scanner.nextLine();
					
					Admin.theaterDatabase.get("Engish").put("SCREEN - 1",movieName);theaterDatabase.get("ENGLISH").put("SCREEN - 1",movieName); // Driect value updation
					 
				}
				else {
					System.out.println("Enter a movie to be played in screen 2 ");
					scanner.nextLine();
					String movieName=scanner.nextLine();
					
					Admin.theaterDatabase.get("ENGLISH").put("SCREEN - 2",movieName);
				}
			}
			else {
				
				System.out.println();
				System.out.println("Enter 1 to change screen 3");
				System.out.println("Enter 2 to change screen 4");
				byte choice1=scanner.nextByte();
				if(choice1 == 1) {
					System.out.println("Enter a movie to be played in screen 3 ");
					scanner.nextLine();
					String movieName=scanner.nextLine();
					
					Admin.theaterDatabase.get("TAMIL").put("SCREEN - 3",movieName);
				}
				else {
					System.out.println("Enter a movie to be played in screen 4 ");
					scanner.nextLine();
					String movieName=scanner.nextLine();
					
					Admin.theaterDatabase.get("TAMIL").put("SCREEN - 4",movieName);
				}
				
			}
			
		}
		
		else {
			System.out.println("Invalid user ");
			System.out.println();
		}
		
		
		
		for(Entry<String,LinkedHashMap<String, String> > entry : Admin.theaterDatabase.entrySet()) {
			System.out.println("KEY : "+entry.getKey()); // key - laguage(STRING)
			LinkedHashMap<String, String> hashMap=entry.getValue(); //VAlue - LINkedHAshmap(SCreen , Movie)
			for(Entry<String, String> entry2 : hashMap.entrySet()) {
				System.out.println(entry2.getKey());
				System.out.println(entry2.getValue());
			}
		}
		
	}

	public void moviesRunning() {
		//english 
		LinkedHashMap<String, String> screen1=new LinkedHashMap<String, String>();
		
		
		screen1.put("SCREEN - 1", "GRAY MAN");
		screen1.put("SCREEN - 2","AVENGERS" );
		
		theaterDatabase.put("ENGLISH", screen1);
		
		//tamil
		
		LinkedHashMap<String, String> screen2=new LinkedHashMap<String, String>();
		
		screen2.put("SCREEN - 3","VIKRAM");
		screen2.put("SCREEN - 4", "DON");
		
		theaterDatabase.put("TAMIL", screen2);
		theaterDatabase.put("TAMIL", screen2);
		
		
		for(Entry<String,LinkedHashMap<String, String> > entry : Admin.theaterDatabase.entrySet()) {
			System.out.println("KEY : "+entry.getKey()); // key - laguage(STRING,LINKEDHASHMAP(SCREEN<MOVIE))
			LinkedHashMap<String, String> hashMap=entry.getValue(); //VAlue - LINkedHAshmap(SCreen , Movie)
			for(Entry<String, String> entry2 : hashMap.entrySet()) {
				System.out.println(entry2.getKey());
				System.out.println(entry2.getValue());
			}
		}
		
	System.out.println();
		
		
	}

}
