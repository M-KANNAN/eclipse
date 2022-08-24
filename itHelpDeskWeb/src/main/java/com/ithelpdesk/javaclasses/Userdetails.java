package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Userdetails {

	HashMap<Integer, TicketDetails> ticket = new LinkedHashMap<Integer, TicketDetails>();

	public HashMap<Integer, TicketDetails> getUserTickets(int userId, boolean isAdmin) {

		ValidatorClass validatorClass = new ValidatorClass();

		String getUserTicketsQuery;

		if (isAdmin) {
			getUserTicketsQuery = "select td.ticket_id  as ticket_Id, ud.user_name as user_name, td.subject , td.description,sd.status_name,td.time_creation\n"
					+ "from ticket_details as td\n" + "LEFT join user_details as ud on ud.user_id = td.user_id\n"
					+ "LEFT join status_details as sd on sd.status_id = td.status_id\n" + "where td.techician_id= ? ";
		} else {

			getUserTicketsQuery = "select td.ticket_id  as ticket_Id, ud.user_name as admin_name, td.subject , td.description,sd.status_name,td.time_creation\n"
					+ "from ticket_details as td\n" + "LEFT join user_details as ud on ud.user_id = td.techician_id\n"
					+ "LEFT join status_details as sd on sd.status_id = td.status_id\n" + "where  td.user_id= ? ;"; // get user tixkets
		}

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(getUserTicketsQuery);
		
		//	System.out.println(userId);

		try {
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				TicketDetails details = new TicketDetails();

				details.setAdminName(resultSet.getString(2));
				details.setSubject(resultSet.getString(3));
				details.setDiscription(resultSet.getString(4));
				details.setTicket_Status(resultSet.getString(5));
				details.setTimeOfCreation(resultSet.getTimestamp(6));
				ticket.put(resultSet.getInt(1), details);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ticket;

	}

	public String getAdminName(String name) {
		
		return name != null ? name : "Not Assigned";
		
	}

	public ArrayList<Integer> getTicketForChat(int userId) throws SQLException {

		ValidatorClass validatorClass = new ValidatorClass();

		String getTicketsForChatsQuery = "select ticket_id from ticket_details\n" + "where status_id in (1,2,3)\n"
				+ "and user_id= ? \n" + "And techician_id is not null; ";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(getTicketsForChatsQuery);

		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		ArrayList<Integer> ticket = new ArrayList<Integer>();

		while (resultSet.next()) {
			ticket.add(resultSet.getInt(1));
		}

		return ticket;
	}

	public ArrayList<Integer> pickUserTickets(int userId) throws SQLException {

		ArrayList<Integer> ticket = new ArrayList<Integer>();
		ValidatorClass validatorClass = new ValidatorClass();

		String pickUserTicketsQuery = "select ticket_id from ticket_details\n"
				+ "where status_id=1 and techician_id is null; ";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(pickUserTicketsQuery);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			ticket.add(resultSet.getInt(1));
		}

		return ticket;
	}

	public void adminTicketPicker(int userId, int ticketId) throws SQLException {

		ValidatorClass validatorClass = new ValidatorClass();

		String getTicketsForChatsQuery = "update ticket_details\n" + "set status_id = 2,\n" + "techician_id= ?\n"
				+ "where ticket_id=?; ";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(getTicketsForChatsQuery);

		preparedStatement.setInt(1, userId);

		preparedStatement.setInt(2, ticketId);

		preparedStatement.executeUpdate();

		preparedStatement.close();

	}

	public void supportRequestStatusChanger(int ticketId , int choice) throws SQLException {

		
		ValidatorClass validatorClass = new ValidatorClass();
		
		String closeSupportRequestQuery = null;
		
		if(choice == 1) {
			closeSupportRequestQuery = "update ticket_details\n"
					+ "set status_id=3\n"
					+ "where ticket_id=?; ";

		}
		else if(choice == 2) {
			closeSupportRequestQuery = "update ticket_details\n"
					+ "set status_id=4\n"
					+ "where ticket_id=?; ";
			
		}
		else if(choice == 3) {
			closeSupportRequestQuery = "update ticket_details\n"
					+ "set status_id=5\n"
					+ "where ticket_id=?; ";
		}

		
		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(closeSupportRequestQuery);

		preparedStatement.setInt(1, ticketId);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
	}

	public ArrayList<Integer> getAdminUser(int userId) throws SQLException {
		
		ArrayList<Integer> ticket = new ArrayList<Integer>();
		ValidatorClass validatorClass = new ValidatorClass();

		String pickUserTicketsQuery = "select user_id from user_details where user_id != ? and is_technician; ";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(pickUserTicketsQuery);
		
		preparedStatement.setInt(1, userId);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			
			ticket.add(resultSet.getInt(1));
			
		}

		return ticket;
		
		
		
	}

	public void updateAdminId(int ticketNo, int adminId) throws SQLException {
		

		ValidatorClass validatorClass = new ValidatorClass();
		

		String closeSupportRequestQuery = "update ticket_details\n"
				+ "set techician_id =  ?\n"
				+ "where ticket_id = ?; ";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(closeSupportRequestQuery);

		preparedStatement.setInt(1, adminId);
		
		preparedStatement.setInt(2, ticketNo);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
		
		
	}

}