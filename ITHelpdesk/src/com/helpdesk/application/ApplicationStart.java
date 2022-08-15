package com.helpdesk.application;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationStart {

	protected static boolean threadStop = true;

	private  void flowManager() {

		boolean isExite = true;

		while (isExite) {
			System.out.println();
			System.out.println("Welcome to IT Helpdesk");
			System.out.println();
			System.out.println("Enter your choice ");
			System.out.println();
			System.out.println("Enter 1 to User Signup");
			System.out.println("Enter 2 to User Login");
			System.out.println("Enter 3 to exit");
			System.out.println();

			switch (ValidatorClass.getValidatedChoice()) {

			case 1:
				//new AdminLogin().adminLogin();
				new UserSignUp().userSignUp();
				break;

			case 2:
				//new UserLogin().userLogin();
				new Login().login();
				
				break;

			case 3:
				new ValidatorClass().closeConnection();
				isExite = false;
				threadStop = false;
				break;

			default:
				break;

			}
		}

	}

	public static void main(String[] args) {

		 new ApplicationStart().flowManager();

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
				

				String deleteChatDetails = "delete from chat_details\n"
						+ "where ticket_id in (select ticket_id from ticket_details where status_id = 5);";

				String deleteTicketTable = "delete from ticket_details\n" + "where status_id=5;";

				PreparedStatement preparedStatement;

				while (threadStop) {
					preparedStatement = new ValidatorClass().getPreparedStatement(deleteChatDetails);
					preparedStatement.executeUpdate();

					preparedStatement = new ValidatorClass().getPreparedStatement(deleteTicketTable);
					preparedStatement.executeUpdate();

					// System.out.println("table row deleted");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
				

			}
		});

		// Create another thread object that calls

//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				flowManager();
//			}
//		});

		// Start both threads

		t1.setDaemon(true);

		t1.start();

//		t2.start();

	}

}
