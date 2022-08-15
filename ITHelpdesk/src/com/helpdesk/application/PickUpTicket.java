package com.helpdesk.application;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PickUpTicket {

	public void pickUpTicket(int userId) throws SQLException {

		String ticketQuery = "select * from ticket_details\n" + "where status_id = 1 and admin_id is null\n"
				+ "ORDER by time_creation asc;";

		PreparedStatement preparedStatement =new ValidatorClass().getPreparedStatement(ticketQuery);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() != 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();
			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();

			while (true) {
				System.out.println("Ticket Number ....");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {

					String updateAdminIdQuery = "update ticket_details\n"
							+ "set status_id=2,\n"
							+ "admin_id= ?\n"
							+ "where tickect_id= ?;";
					preparedStatement = new ValidatorClass().getPreparedStatement(updateAdminIdQuery);
					
					preparedStatement.setInt(1, userId);

					preparedStatement.setInt(2, ticketnumber);

					preparedStatement.executeUpdate();

					System.out.println();
					System.out.println("!!! You picked a request sucessfully !!!");
					System.out.println();

					preparedStatement.close();
					break;

				} else {
					System.out.println();
					System.out.println("Enter a vaid ticket number");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! No Ticket Avaiable !!!");
			System.out.println();
		}


	}
	
	
	
	public void archiveAndTrashTicketsMenu(int userId, int status_id) throws SQLException {
		
		
		boolean isExit=true;
		
		while(isExit) {
			if (status_id == 3) {
				System.out.println();
				System.out.println("  ** Welcome to Archive menu **");
				System.out.println();
				System.out.println("Enter 1 to view Archive  support request");
				System.out.println("Enter 2 to Archive the closed support request");
				System.out.println("Enter 3 to exit");
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println("  ** Welcome to Trashed menu **");
				System.out.println();
				System.out.println("Enter 1 to view Trashed support request");
				System.out.println("Enter 2 to Trash the archivesupport request");
				System.out.println("Enter 3 to exit");
				System.out.println();
			}
			
			switch(ValidatorClass.getValidatedChoice()) {
			
			case 1 :
				new ViewTicketDetails().viewArchiveTrashedTickets(userId,status_id);
				break;
				
			case 2 :
				archiveAndTrashTickets(userId, status_id);
				break;
			case 3 :
				System.out.println();
				System.out.println(" !!! Redirecting to Admin Menu !!!");
				System.out.println();
				isExit=false;
				
			default :
				System.out.println();
				System.out.println(" !!! Enter a valid choice !!!");
				System.out.println();
			
			}
		
			
			
		}
		
		
	}
	
	
	

	public void archiveAndTrashTickets(int userId, int status_id) throws SQLException {
 
		String ticketQuery = "select * from ticket_details\n" + "where status_id= ? and admin_id= ?\n"
				+ "ORDER by time_creation asc;";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, status_id );
		preparedStatement.setInt(2, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() != 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();

			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();

			while (true) {
				System.out.println("Ticket Number...");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {

					String updateAdminIdQuery = "update ticket_details\n" + "set status_id = ?\n"
							+ "where tickect_id = ?;";
					
					preparedStatement =new ValidatorClass().getPreparedStatement(updateAdminIdQuery);

					preparedStatement.setInt(1, (status_id+1));
					preparedStatement.setInt(2, ticketnumber);

					preparedStatement.executeUpdate();

					System.out.println();
					System.out.println("!!! Your ticket Status changed Sucessfully !!!");
					System.out.println();

					preparedStatement.close();
					break;

				} else {
					System.out.println();
					System.out.println("Enter a vaid ticket number");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! No Ticket Avaiable !!!");
			System.out.println();
		}


	}

	public void taskAssignerToOtherAdmin(int userId) throws SQLException {


		//Connection connection = DBConnection.getInstance().getConnection();
		
		String availabletickets="select * from ticket_details\n"
				+ "where admin_id= ? and status_id in (1,2);";
		
		PreparedStatement preparedStatement=new ValidatorClass().getPreparedStatement(availabletickets);
		
		preparedStatement.setInt(1, userId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() != 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();
			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();

			while (true) {
				System.out.println("Ticket Number....");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {

					

					String getAdminUsersQuery = "select user_id,user_name from user_details where is_admin and user_id != ?;"; // no assignment to same admin

					preparedStatement = new ValidatorClass().getPreparedStatement(getAdminUsersQuery);

					preparedStatement.setInt(1, userId);

					ResultSet resultSet1 = preparedStatement.executeQuery();

					ArrayList<Integer> adminList = new ArrayList<Integer>();

					while (resultSet1.next()) {

						System.out.print("Admin ID : " + resultSet1.getInt("user_id") + "\t");
						adminList.add(resultSet1.getInt("user_id"));
						System.out.print("Admin name : " + resultSet1.getString("user_name"));
						System.out.println();
					}
					
					if(adminList.size() != 0) {
						
						
						int adminId=0;
						while(true) {
							System.out.println("Admin ID...");
							adminId=ValidatorClass.getValidatedTicketNumberandAdminId(2);
							
							if(adminList.contains(adminId)) {
								break;
							}
							else {
								System.out.println("Invalid admin");
							}
						}
						
						String technicianChangeQuery="update ticket_details\n"
								+ "set admin_id= ? \n"
								+ "where tickect_id= ?;";
						
						preparedStatement=new ValidatorClass().getPreparedStatement(technicianChangeQuery);
						
						preparedStatement.setInt(1, adminId);
						preparedStatement.setInt(2, ticketnumber);
						
						preparedStatement.executeUpdate();
						
					}
					else {
						System.out.println();
						System.out.println("!!! No admin avaliable !!!");
						System.out.println();
					}
					
					resultSet1.close();
					System.out.println();
					System.out.println(" !!! Admin updated sucessfully !!!");
					System.out.println();
					break;

				} else {
					System.out.println();
					System.out.println("Enter a vaid ticket number");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! No Ticket Avaiable !!!");
			System.out.println();
		}
		
		
		resultSet.close();
		preparedStatement.close();

	}

}
