package com.helpdesk.application;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class AdminLogin {

	public void adminLogin() {
		
		System.out.println("UserName...");
		
		String name=ValidatorClass.getValidatedName();
		System.out.println("Password...");
		String pasword = ValidatorClass.getValidPassWord();

		try {

			
			String adminLoginQuery="select user_id from user_details\n" + "where user_name= ? and user_pass= ? and is_admin;";
			
			PreparedStatement preparedStatement=new ValidatorClass().getPreparedStatement(adminLoginQuery);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pasword);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getInt("user_id") != 0) {
					System.out.println();
					System.out.println("!!! Login Sucessfull !!!");
					System.out.println();
					int userId = resultSet.getInt("user_id");
					this.adminLoginMenu(userId);
				} else {
					System.out.println();
					System.out.println("!!! Invalid login !!!");
					System.out.println();
				}
			} else {
				System.out.println();
				System.out.println("!!! Invalid login !!!");
				System.out.println();
			}
			
			resultSet.close();
			preparedStatement.close();
			

		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		
	}

	private void adminLoginMenu(int userId) {
		
		Scanner scanner = new Scanner(System.in);

		boolean isExit = true;

		try {
			while (isExit) {
				System.out.println();
				System.out.println(" ** Welcome to Admin login **");
				System.out.println();
				System.out.println("Enter 1 to Raise ticket");
				System.out.println("Enter 2 to View ticket");
				System.out.println("Enter 3 to Update ticket");
				System.out.println("Enter 4 to Pick a user request");
				System.out.println("Enter 5 to check my assigend tickets");
				System.out.println("Enter 6 to archive a closed chats");
				System.out.println("Enter 7 to delete a archived chats");
				System.out.println("Enter 8 to Exit");
				System.out.println();


				switch (ValidatorClass.getValidatedChoice()) {
			
				case 1:
					new Raiseticket().adminTicketRaiser(userId);
					break;

				case 2:
					new ViewTicketDetails().userTicketViewerMenu(userId , true); // when admin created a request
					break;
					
				case 3:
					new Raiseticket().updateAdminTicketDetails(userId);
					break;
					
				case 4 :
					new  PickUpTicket().pickUpTicket(userId);
					break;
					
				case 5:
					new MyAssignedTicket().assignedTaskMenu(userId);
					break;
					
				case 6 :
					try {	
						new PickUpTicket().archiveAndTrashTicketsMenu(userId,3);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					break;
					
				case 7 :
					try {
						new PickUpTicket().archiveAndTrashTicketsMenu(userId,4);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					break;

				case 8:
					isExit = false;
					break;

				default:
					System.out.println();
					System.out.println("!!! Invalid Choice !!!");
					System.out.println();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
