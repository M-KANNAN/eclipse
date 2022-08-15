package com.helpdesk.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.helpdesk.dbconnection.DBConnection;

public class Raiseticket {

	public void userTicketRaiser(int userId) throws SQLException {

		System.out.println();
		System.out.println("Subject : ");

		String subject = ValidatorClass.getSubjectDiscription(1);

		System.out.println();
		System.out.println("Discription : ");
		String discription = ValidatorClass.getSubjectDiscription(2);

		
		String userTicketQuery="insert into ticket_details(user_id,subject,discription,time_creation,status_Id)\n"
				+ "values\n" + "(?,?,?,?,?) RETURNING tickect_id ;";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(userTicketQuery);

		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, discription);
		preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(5, 1);
		preparedStatement.execute();

		ResultSet last_updated_person = preparedStatement.getResultSet(); // Using getResultSet()
		if(last_updated_person != null && last_updated_person.next()) {
			System.out.println();
		  System.out.println("Your request Id : "+last_updated_person.getInt(1));
		  System.out.println();
		}
		else {
			System.out.println("Null");
		}
		
		last_updated_person.close();
		preparedStatement.close();

	}

	public void updateUserTicketDetails(int userId) throws SQLException {


		String ticketQuery = "select tickect_id from ticket_details \n" + "where user_id= ? and status_Id in (1,2);";

		PreparedStatement preparedStatement =new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		System.out.println();
		System.out.println("Select any one ticket listed here : " + ticketList);
		System.out.println();
		while (true) {
			System.out.println("Ticket Number...");
			int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

			if (ticketList.contains(ticketnumber)) {

				this.updaterMenu(ticketnumber);

				break;

			} else {
				System.out.println();
				System.out.println("Enter a vaid ticket number");
				System.out.println();
			}

		}

		System.out.println();
		System.out.println("!!! Details Updated Sucessfully !!!");
		System.out.println();

	}

	public void adminTicketRaiser(int userId) throws SQLException {

		Connection connection = DBConnection.getInstance().getConnection();

		System.out.println();
		System.out.println("Subject : ");

		String subject = ValidatorClass.getSubjectDiscription(1);

		System.out.println();
		System.out.println("Discription : ");
		String discription = ValidatorClass.getSubjectDiscription(2);

		String getAdminUsersQuery = "select user_id,user_name from user_details where is_admin and user_id != ?;";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(getAdminUsersQuery);

		preparedStatement.setInt(1, userId);

		ResultSet resultSet2 = preparedStatement.executeQuery();

		ArrayList<Integer> adminList = new ArrayList<Integer>();

		while (resultSet2.next()) {

			System.out.print("Admin ID : " + resultSet2.getInt("user_id") + "\t");
			adminList.add(resultSet2.getInt("user_id"));
			System.out.print("Admin name : " + resultSet2.getString("user_name"));
			System.out.println();
		}

		resultSet2.close();
		preparedStatement.close();

		int adminId = 0;
		while (true) {
			System.out.println("Admin ID...");
			adminId = ValidatorClass.getValidatedTicketNumberandAdminId(2);

			if (adminList.contains(adminId)) {
				break;
			} else {
				System.out.println("Invalid admin");
			}
		}

		preparedStatement = connection.prepareStatement(
				"insert into ticket_details(user_id,subject,discription,time_creation,status_Id,admin_id)\n"
						+ "values\n" + "(?,?,?,?,?,?); ",PreparedStatement.RETURN_GENERATED_KEYS);

		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, discription);
		preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(5, 2);
		preparedStatement.setInt(6, adminId);

		preparedStatement.execute();

		ResultSet last_updated_person = preparedStatement.getGeneratedKeys(); // using generatedkeys method
		if(last_updated_person != null && last_updated_person.next()) {
			System.out.println();
		  System.out.println("Your request Id : "+last_updated_person.getInt(1));
		  System.out.println();
		}
		else {
			System.out.println("Null");
		}
		
		last_updated_person.close();
		preparedStatement.close();
		connection.close();

	}

	public void updateAdminTicketDetails(int userId) throws SQLException {

	//	Connection connection = DBConnection.getInstance().getConnection();

		String ticketQuery = "select tickect_id from ticket_details \n" + "where user_id= ? and status_Id in (1,2);";

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticketList = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticketList.add(resultSet.getInt("tickect_id"));
		}

		System.out.println();
		System.out.println("Select any one ticket listed here : " + ticketList);
		System.out.println();
		while (true) {
			System.out.println("Ticket Number...");
			int ticketnumber = ValidatorClass.getValidatedTicketNumberandAdminId(1);

			if (ticketList.contains(ticketnumber)) {
				

				this.updaterMenu(ticketnumber);

				break;

			} else {
				System.out.println();
				System.out.println("Enter a vaid ticket number");
				System.out.println();
			}

		}

		System.out.println();
		System.out.println("!!! Details Updated Sucessfully !!!");
		System.out.println();

	}

	private void updaterMenu(int ticketnumber) throws SQLException {

		//Connection connection = DBConnection.getInstance().getConnection();

		String ticketQuery = "select * from ticket_details where tickect_id = ?;"; // shows only one because of null

		PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(ticketQuery);

		preparedStatement.setInt(1, ticketnumber);
		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.println();
		System.out.println(" ** Your ticket **");
		System.out.println();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			if (resultSet.getInt("admin_id") == 0) {
				System.out.println("Admin Not Assigned");
			} else {

				System.out.println("Assigned to : " + ViewTicketDetails.getUserName(resultSet.getInt("admin_id")));
			}
			System.out.println("Requested by : " + ViewTicketDetails.getUserName(resultSet.getInt("user_Id")));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + ViewTicketDetails.getUserName(resultSet.getInt("status_Id")));
			System.out.println("         **   ");
			System.out.println();

		}

		boolean isExit = true;

		while (isExit) {

			System.out.println();
			System.out.println(" ** Update Menu **");
			System.out.println();
			System.out.println("Enter 1 to update Subject ");
			System.out.println("Enter 2 to update Discription");
			System.out.println("Enter 3 to exit");
			System.out.println();

			switch (ValidatorClass.getValidatedChoice()) {
			case 1:

				System.out.println();
				System.out.println("Subject : ");

				String subject = ValidatorClass.getSubjectDiscription(1);
				String ticketSubjectUpdateQuery = "update ticket_details\n" + "set subject= ?\n"
						+ "where tickect_id=?;";
				preparedStatement = new ValidatorClass().getPreparedStatement(ticketSubjectUpdateQuery);
				preparedStatement.setString(1, subject);
				preparedStatement.setInt(2, ticketnumber);

				System.out.println();
				System.out.println("!!!Subject Updated Sucessfully !!!");

				preparedStatement.executeUpdate();
				preparedStatement.close();

				break;

			case 2:

				System.out.println();
				System.out.println("Discription : ");
				String discription = ValidatorClass.getSubjectDiscription(2);

				String ticketUpdateQuery = "update ticket_details\n" + "set discription= ? \n" + "where tickect_id=?;";

				preparedStatement = new ValidatorClass().getPreparedStatement(ticketUpdateQuery);
				preparedStatement.setString(1, discription);
				preparedStatement.setInt(2, ticketnumber);

				preparedStatement.executeUpdate();
				System.out.println();
				System.out.println(" !!! Discription updated Sucessfully !!!");
				System.out.println();
				preparedStatement.close();

				break;

			case 3:
				System.out.println();
				System.out.println("!!! Redirecting to request menu !!!");
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println("Enter a valid choice");
				System.out.println();
				break;

			}
		}

	}

}
