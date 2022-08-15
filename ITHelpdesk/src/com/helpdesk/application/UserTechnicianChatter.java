package com.helpdesk.application;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


public class UserTechnicianChatter {

	public void userTechChat(int userId) throws SQLException {


		String ticketQuery = "select tickect_id from ticket_details \n"
				+ "where user_id= ? and admin_id is not  null and status_id in(1,2,3);";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);
		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() > 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();
			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();
			while (true) {
				System.out.println("Ticket number...");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {

					// closed to open

					String closeToOpenQuery = "update ticket_details\n" + "set status_id=1, admin_id=null\n"
							+ "where tickect_id = ? and status_id=3;";

					preparedStatement = new ValidatorClass().getPreparedStatement(closeToOpenQuery);
					
					preparedStatement.setInt(1, ticketnumber);
					int update = preparedStatement.executeUpdate();

					if (update == 0) {
						// chat query
						String chatQuery = "select user_id,admin_id from ticket_details\n" + "where tickect_id= ?;";
						
						preparedStatement = new ValidatorClass().getPreparedStatement(chatQuery);
						
						preparedStatement.setInt(1, ticketnumber);
						ResultSet resultSet2 = preparedStatement.executeQuery();

						if (resultSet2.next()) {
							replayToChat(ticketnumber, resultSet2.getInt("user_id"), resultSet2.getInt("admin_id"));
						}
					}

					else {
						System.out.println();
						System.out.println("!!! You opened a closed ticket and no admin assigned !!!");
						System.out.println();
					}

					break;

				} else {
					System.out.println();
					System.out.println("Enter a vaid ticket number");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! Still Admin is not assigned for your ticket");
			System.out.println();
		}

		resultSet.close();
		preparedStatement.close();

	}

	private void replayToChat(int ticketnumber, int senderId, int reciverID) throws SQLException {
		
		
		System.out.println("Message ...");

		String message = ValidatorClass.getSubjectDiscription(3);

		if (message.toLowerCase().contains("closed")) {
			closeRequestHandler(ticketnumber);
		}

		String chatForAdmin = "insert into chat_details(ticket_id,sender_id,reciver_id,isadmin,chat_message,timeof_creation)\n"
				+ "values\n" + "(?,?,?,?,?,?);"; //

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(chatForAdmin);

		preparedStatement.setInt(1, ticketnumber);
		preparedStatement.setInt(2, senderId);
		preparedStatement.setInt(3, reciverID);

		String adminCheckQuery = "select is_admin from user_details\n" + "where user_id=?;";

		PreparedStatement preparedStatement2 =new ValidatorClass().getPreparedStatement(adminCheckQuery);

		preparedStatement2.setInt(1, senderId);

		ResultSet resultSet = preparedStatement2.executeQuery();

		if (resultSet.next()) {
			preparedStatement.setBoolean(4, resultSet.getBoolean("is_admin"));
		}

		preparedStatement.setString(5, message);
		preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

		preparedStatement.executeUpdate();

		preparedStatement2.close();
		preparedStatement.close();

	}

	protected static void closeRequestHandler(int ticketnumber) throws SQLException {


		String userNameGetter = "update ticket_details\n" + "set status_id=3\n" + "where tickect_id = ?;";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(userNameGetter);
		preparedStatement.setInt(1, ticketnumber);

		preparedStatement.executeUpdate();

		preparedStatement.close();
		
	}

	public void techUserChat(int userId) throws SQLException {


		String ticketQuery = "select tickect_id from ticket_details \n"
				+ "where admin_id= ? and admin_id is not  null and status_id in(1,2);";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);
		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() > 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();
			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();
			while (true) {
				System.out.println("Ticket number...");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {

					// closed to open

					String closeToOpenQuery = "update ticket_details\n" + "set status_id=1, admin_id=null\n"
							+ "where tickect_id = ? and status_id=3;";

					preparedStatement = new ValidatorClass().getPreparedStatement(closeToOpenQuery);
					preparedStatement.setInt(1, ticketnumber);

					int update = preparedStatement.executeUpdate();

					if (update == 0) {
						// chat query
						String chatQuery = "select user_id,admin_id from ticket_details\n" + "where tickect_id= ?;";
						
						preparedStatement = new ValidatorClass().getPreparedStatement(chatQuery);
						preparedStatement.setInt(1, ticketnumber);
						ResultSet resultSet2 = preparedStatement.executeQuery();

						if (resultSet2.next()) {
							// change sender and reciver because tech is chatting with user
							replayToChat(ticketnumber, resultSet2.getInt("admin_id"), resultSet2.getInt("user_id")); 
						}
					} else {
						System.out.println();
						System.out.println("!!! You opened a closed ticket and no admin assigned !!!");
						System.out.println();
					}

					break;

				} else {
					System.out.println();
					System.out.println("Enter a vaid ticket number");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! No ticket Available !!!");
			System.out.println();
		}

		resultSet.close();
		preparedStatement.close();
	

	}
	
	public void chatModule(int userId,int choice , boolean isAdmin) throws SQLException {
		
		String availabeTicketQuery;
		
		if(choice == 1) {
			//  Query if he is a user
			availabeTicketQuery = "select tickect_id from ticket_details \n"
					+ "where user_id= ? and admin_id is not  null and status_id in(1,2,3);";
			
		}
		else {
			// Query if he is a Technicaian
			availabeTicketQuery = "select tickect_id from ticket_details \n"
					+ "where admin_id= ? and admin_id is not  null and status_id in(1,2);";
		}
		
		
		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(availabeTicketQuery);
		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		if (ticketList.size() > 0) {

			System.out.println();
			System.out.println(" !!! Available tickets with assigned Admins !!!");
			System.out.println();
			System.out.println("Select any one ticket listed here : " + ticketList);
			System.out.println();
			while (true) {
				System.out.println("Ticket number...");
				int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

				if (ticketList.contains(ticketnumber)) {
					
					String closeToOpenQuery;

					int update=0;
					
					if(choice == 1) { // only user can open the closed ticket  not required
						
						if(isAdmin) { // for admin users don't make admin null
							closeToOpenQuery = "update ticket_details\n" + "set status_id=2\n"
									+ "where tickect_id = ? and status_id=3;"; 
						}
						else {
							closeToOpenQuery = "update ticket_details\n" + "set status_id=1, admin_id=null\n"
									+ "where tickect_id = ? and status_id=3;";
						}
						
						preparedStatement = new ValidatorClass().getPreparedStatement(closeToOpenQuery);
						preparedStatement.setInt(1, ticketnumber);

						update = preparedStatement.executeUpdate();
						 
					}

					if (update == 0) {
						// chat query
						String chatQuery = "select user_id,admin_id from ticket_details\n" + "where tickect_id= ?;";
						
						preparedStatement = new ValidatorClass().getPreparedStatement(chatQuery);
						preparedStatement.setInt(1, ticketnumber);
						ResultSet resultSet2 = preparedStatement.executeQuery();

						if (resultSet2.next()) {
							
							if(choice == 1) {
								// User chat here user is chatting
								replayToChat(ticketnumber, resultSet2.getInt("user_id"), resultSet2.getInt("admin_id"));
								
							}
							else {
								// Technician chat here technician is chatting
								replayToChat(ticketnumber, resultSet2.getInt("admin_id"), resultSet2.getInt("user_id")); 
							}
						
							
						}
					} else {
						System.out.println();
						System.out.println("!!! You opened a closed ticket and no admin assigned !!!");
						System.out.println();
					}

					break;

				} else {
					System.out.println();
					System.out.println(" !!! Enter a vaid ticket number  !!!");
					System.out.println();
				}

			}

		} else {
			System.out.println();
			System.out.println("!!! No ticket Available !!!");
			System.out.println();
		}

		resultSet.close();
		preparedStatement.close();
	

		
	}

}
