package com.helpdesk.main;

import java.util.Scanner;


public class ApplicationStart {
	
	private void flowManager() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		boolean isExite=true;
		
		while(isExite) {
			System.out.println("");
			System.out.println("Welcome to IT Helpdesk");
			System.out.println();
			System.out.println("Enter your choice ");
			System.out.println();
			System.out.println("Enter 1 to user login");
			System.out.println("Enter 2 to admin login");
			System.out.println("Enter 3 to exit");
			System.out.println();
			
			switch (scanner.nextInt()) {
			
			case 1 :
				new UserLogin().userLogin();
				break;
				
			case 2 :
				new AdminLogin().adminLogin();
				break;
				
			case 3 :
				isExite=false;
				break;
				
			default :
				break;
			
			}
		}
		
	}


	public static void main(String[] args) {
		//new Usercreation().userCreation();
		//new TechnicianCreation().technicianCreation();
		new ApplicationStart().flowManager();
		

	}

	
}
