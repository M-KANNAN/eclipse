package com.helpdesk.application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyAssignedTicket {

	public void assignedTaskMenu(int userId) {

		boolean isExit = true;

		while (isExit) {

			System.out.println();
			System.out.println("  ** Welecome to Assigned Task Menu");
			System.out.println();
			System.out.println("Enter 1 to view all assigned Task");
			System.out.println("Enter 2 to chat with support request raised users");
			System.out.println("Enter 3 to assign my task to diffrent admin");
			System.out.println("Enter 4 to exit");

			switch (ValidatorClass.getValidatedChoice()) {

			case 1:
				try {
					myAssignedTicket(userId);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;

			case 2:
				try {
					new UserTechnicianChatter().chatModule(userId , 2 , true); // isAdmin = true
				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;

			case 3:

				try {
					new PickUpTicket().taskAssignerToOtherAdmin(userId);
					break;

				} catch (Exception e) {

					e.printStackTrace();
				}

			case 4:
				System.out.println("!!! Redirecting to admin Login !!!");
				System.out.println();
				isExit = false;

			default:
				System.out.println();
				System.out.println("!!! Enter a valid choice !!!");
				System.out.println();

			}

		}

	}

	public void myAssignedTicket(int userId) throws SQLException {

		String ticketQuery = "select * from ticket_details where admin_id= ? and status_id in (1,2);"; 
		
		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));

			System.out.println("Assigned to : " + ViewTicketDetails.getUserName(resultSet.getInt("admin_id")));

			System.out.println("Requested by : " + ViewTicketDetails.getUserName(resultSet.getInt("user_Id")));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + ViewTicketDetails.statusChecker(resultSet.getInt("status_Id")));
			System.out.println("         **   ");
			System.out.println();

			System.out.println(" ** Conversation for the ticket **");
			System.out.println();

			String adminAssignedCheck = "select admin_id,user_id from ticket_details \n" + "where tickect_id= ? ;";

			preparedStatement = new ValidatorClass().getPreparedStatement(adminAssignedCheck);

			preparedStatement.setInt(1, resultSet.getInt("tickect_id"));

			ResultSet resultSet1 = preparedStatement.executeQuery();
			if (resultSet1.next() && resultSet1.getInt("admin_id") != 0) { // admin is assiged or not

				String chatQuerry = "SELECT ud.user_name,cd.chat_message FROM chat_details AS cd\n"
						+ "INNER join  user_details as ud on ud.user_id = cd.sender_id\n" + "WHERE cd.ticket_id= ? ;";

				preparedStatement = new ValidatorClass().getPreparedStatement(chatQuerry);

				preparedStatement.setInt(1, resultSet.getInt("tickect_id"));
				ResultSet resultSet2 = preparedStatement.executeQuery();

				while (resultSet2.next()) {
					System.out.println("Sender : " + resultSet2.getString("user_name") + " Message : "
							+ resultSet2.getString("chat_message"));
				}
				resultSet2.close();

			} else {
				System.out.println();
				System.out.println("!!! Chat option unavailable because of admin not assigned !!!");
				System.out.println();
			}
			resultSet1.close();

		}

		resultSet.close();
		preparedStatement.close();

	}

}
