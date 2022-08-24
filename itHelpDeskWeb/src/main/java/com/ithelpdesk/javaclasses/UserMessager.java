package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserMessager {

	public void userMessager(int userId, int ticketId, String message) throws SQLException {

		ValidatorClass validatorClass = new ValidatorClass();
		
		
		this.closedTicketHander(ticketId);

		String chatQuery = "insert into chat_details(sender_id,reciver_id,chat_message,ticket_id,timeof_creation)\n"
				+ "values(?,?,?,?,?);";
		
		int ticketUserId=this.getUserId(ticketId);
		
		int ticketAdminId=this.getAdminId(ticketId);

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(chatQuery);
		
		preparedStatement.setInt(1, userId);
		
//		System.out.println(userId);
		
		if(userId == ticketUserId) {
			preparedStatement.setInt(2,ticketAdminId );
		}
		else {
			preparedStatement.setInt(2,ticketUserId);
		}
		
		
//		System.out.println(this.getAdminId(ticketId));
		
		preparedStatement.setString(3, message);
		
//		System.out.println(message);
		
		
		
		preparedStatement.setInt(4, ticketId);
		
//		System.out.println(ticketId);
		
		preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
		
		

	}

	private void closedTicketHander(int ticketId) throws SQLException {
		
		ValidatorClass validatorClass = new ValidatorClass();
		
		String closedTicketQuerry = "update ticket_details\n"
				+ "set status_id=2\n"
				+ "where ticket_id= ? and status_id=3;";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(closedTicketQuerry);
		
		preparedStatement.setInt(1, ticketId);
		
		preparedStatement.executeUpdate();
		
		
	}

	protected int getAdminId(int ticketId) throws SQLException {
		
		ValidatorClass validatorClass = new ValidatorClass();

		String chatQuery = "select techician_id from ticket_details where ticket_id=?;";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(chatQuery);
		
		preparedStatement.setInt(1, ticketId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.next();
		
		return resultSet.getInt(1);
	}

	protected int getUserId(int ticketId) throws SQLException {
		
		ValidatorClass validatorClass = new ValidatorClass();

		String chatQuery = "select user_id from ticket_details where ticket_id=?;";

		PreparedStatement preparedStatement = validatorClass.getPreparedStatement(chatQuery);
		
		preparedStatement.setInt(1, ticketId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.next();
		
		return resultSet.getInt(1);
	}
	
}
