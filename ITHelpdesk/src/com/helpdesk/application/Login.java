package com.helpdesk.application;


public class Login {

	public void login() {
		
		
		boolean isExite = true;

		while (isExite) {
			System.out.println();
			System.out.println(" ** Welcome Login menu **");
			System.out.println();
			System.out.println("Enter your choice ");
			System.out.println();
			System.out.println("Enter 1 to admin Login");
			System.out.println("Enter 2 to user Login");
			System.out.println("Enter 3 to exit");
			System.out.println();

			switch (ValidatorClass.getValidatedChoice()) {

			case 1:
				new AdminLogin().adminLogin();
				break;

			case 2:
				new UserLogin().userLogin();
				break;

			case 3:
				isExite = false;
				
				break;

			default:
				break;

			}
		}
		
	}

}
