package com.bankingapplication.main;
import com.bankingapplication.methods.*;

public class ApplicationStart {
	
	byte count=0;
	
	private void flowManager() {
		
		boolean isExit=true;
		
		while(isExit) {
			
			if(count < 3) {
				System.out.println();
				System.out.println("WELCOME TO NATIONAL BANK");
				System.out.println();
				System.out.println("  **Main Menu**");
				System.out.println();
				System.out.println("Enter your choice");
				System.out.println();
				System.out.println("Enter 1 to add users ");
				System.out.println("Enter 2 to user login");
				System.out.println("Enter 3 to exit");
				
				switch(Applicationmethods.choiceValidator()) {
				
				case 0 :
					System.out.println();
					System.out.println("!!! Maximum attempt limit exeeds !!!");
					System.out.println();
					System.out.println("!!! Thank You");
					isExit=false;
					break;
				
				case 1 :
					break;
					
				case 2 :
					break;
					
				case 3 :
					System.out.println();
					System.out.println("!!! Thank You");
					isExit=false;
					break;
					
				default :
					++count;
					System.out.println();
					System.out.println("!!! invalid choice !!!");
					System.out.println();
					break;
				
				}
				
			}
			else {
				System.out.println();
				System.out.println("!!! Maximum attempt limit exeeds !!!");
				System.out.println();
				System.out.println("!!! Thank You");
				isExit=false;
			}

		}
		
		
	}
	public static void main(String[] args) {
		
		new ApplicationStart().flowManager();

	}
}
