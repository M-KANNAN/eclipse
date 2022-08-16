package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTicketUpdater {


	public void userTicketUpdater(String subject, String discription, int ticketNo) throws SQLException {
		
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String userTicketUpdateQuery="Update ticket_details\n"
				+ "set subject= ?,\n"
				+ "discription= ? \n"
				+ "where tickect_id=?;";

		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(userTicketUpdateQuery);
		
		preparedStatement.setString(1, subject);
		preparedStatement.setString(2, discription);
		preparedStatement.setInt(3, ticketNo);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
		
		
		
	}
	
}
