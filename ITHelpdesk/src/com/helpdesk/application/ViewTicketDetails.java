package com.helpdesk.application;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewTicketDetails {

	public void userTicketViewerMenu(int userId , boolean isAdmin ) {

		boolean isExite = true;
		while (isExite) {
			System.out.println();
			System.out.println(" ** User Ticket Details Menu **");
			System.out.println();
			System.out.println("Enter 1 to view user ticket details");
			System.out.println("Enter 2 to chat for our rasied tickets");
			System.out.println("Enter 3 to exit");
			System.out.println();
			switch (ValidatorClass.getValidatedChoice()) {
			case 1:
				try {
					tickectdetailsViewer(userId);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;

			case 2:
				try {
					new UserTechnicianChatter().chatModule(userId , 1 , isAdmin);  // User = 1 and is isAdmin= false
				} catch (SQLException e) {

					e.printStackTrace();
				}
				break;

			case 3:
				isExite = false;
				System.out.println("!!! Redirecting to user menu !!!");
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println(" !!! Enter a valid choice !!!");
				System.out.println();
				break;

			}

		}

	}

	public void tickectdetailsViewer(int userId) throws SQLException {


		String ticketQuery = "select * from ticket_details where user_id= ? and status_id in (1,2,3);"; 

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.println();
		System.out.println(" ** Your tickets **");
		System.out.println();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			if (resultSet.getInt("admin_id") == 0) {
				System.out.println("Admin Not Assigned");
			} else {

				System.out.println("Assigned to : " + getUserName(resultSet.getInt("admin_id")));
			}
			System.out.println("Requested by : " + getUserName(resultSet.getInt("user_Id")));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + statusChecker(resultSet.getInt("status_Id")));
			System.out.println("         **   ");
			System.out.println();

			if (resultSet.getInt("admin_id") != 0) { // admin is assiged or not

				System.out.println(" ** Conversation for the ticket **");
				System.out.println();

				String chatQuerry = "SELECT ud.user_name,cd.chat_message FROM chat_details AS cd\n"
						+ "INNER join  user_details as ud on ud.user_id = cd.sender_id\n"
						+ "WHERE cd.ticket_id= ? order by timeof_creation desc;";

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

		}

		resultSet.close();
		preparedStatement.close();

	}

	public static String getUserName(int userId) throws SQLException {
		

		String userNameGetter = "select user_name from user_details\n" + "where user_id= ?;";

		PreparedStatement preparedStatement =new ValidatorClass().getPreparedStatement(userNameGetter);
		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		String userName = "";
		if (resultSet.next()) {
			userName = resultSet.getString("user_name");
		} else {
			userName = null;
		}

		resultSet.close();
		preparedStatement.close();

		return userName;
	}

	public static String statusChecker(int i) {

		if (i == 1) {
			return "open";
		} else if (i == 2) {
			return "inprogress";
		} else if (i == 3) {
			return "closed";
		} else if (i == 4) {
			return "archived";
		} else {
			return "trashed";
		}

	}

	public void viewArchiveTrashedTickets(int userId, int status_id) throws SQLException {
		

		String ticketQuery = "select * from ticket_details\n" + "where admin_id=? and status_id=?;"; 

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, (status_id + 1));

		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.println();
		System.out.println(" ** Your tickets **");
		System.out.println();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			if (resultSet.getInt("admin_id") == 0) {
				System.out.println("Admin Not Assigned");
			} else {

				System.out.println("Assigned to : " + getUserName(resultSet.getInt("admin_id")));
			}
			System.out.println("Requested by : " + getUserName(resultSet.getInt("user_Id")));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + statusChecker(resultSet.getInt("status_Id")));
			System.out.println("         **   ");
			System.out.println();

			if (resultSet.getInt("admin_id") != 0) { // admin is assiged or not

				System.out.println(" ** Conversation for the ticket **");
				System.out.println();

				String chatQuerry = "SELECT ud.user_name,cd.chat_message FROM chat_details AS cd\n"
						+ "INNER join  user_details as ud on ud.user_id = cd.sender_id\n"
						+ "WHERE cd.ticket_id= ? order by timeof_creation desc;";

				preparedStatement =new ValidatorClass().getPreparedStatement(chatQuerry);

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

		}

		resultSet.close();
		preparedStatement.close();

	}

}
