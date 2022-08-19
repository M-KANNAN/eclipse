package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TrashCleaner {
	
	public void trashCleaner() {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					trashFunction();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}

			private synchronized void trashFunction() throws SQLException {
				
				ValidatorClass validatorClass = new ValidatorClass();
				

				String deleteChatDetails = "delete from chat_details\n"
						+ "where ticket_id in (select ticket_id from ticket_details where status_id = 5);";

				String deleteTicketTable = "delete from ticket_details\n" + "where status_id=5;";

				PreparedStatement preparedStatement;

				
					preparedStatement = validatorClass.getPreparedStatement(deleteChatDetails);
					preparedStatement.executeUpdate();

					preparedStatement = new ValidatorClass().getPreparedStatement(deleteTicketTable);
					preparedStatement.executeUpdate();

				
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					
				}
				finally {
					validatorClass.closeConnection();
				}
				

			}
		});

		t1.setDaemon(true);

		t1.start();
		
		
	}
	
	

}
