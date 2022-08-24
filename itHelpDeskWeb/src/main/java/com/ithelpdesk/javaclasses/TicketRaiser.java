package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class TicketRaiser {

	public int userSupportTicketRaiser(String subject, String discription, int userId) throws SQLException {
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String userTicketQuery="insert into ticket_details(user_id,subject,description,time_creation,status_Id)\n"
				+ "values\n" + "(?,?,?,?,?) RETURNING ticket_id ;";

		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(userTicketQuery);

		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, discription);
		preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(5, 1);
		preparedStatement.execute();

		ResultSet last_updated_person = preparedStatement.getResultSet(); // Using getResultSet()
		
		int ticketId=1;
		if(last_updated_person != null && last_updated_person.next()) {
			
			ticketId=last_updated_person.getInt(1);
	
		}
		return ticketId;
		
	}
	

}
