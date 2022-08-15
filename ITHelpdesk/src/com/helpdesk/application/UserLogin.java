package com.helpdesk.application;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin {

	public void userLogin() {


		System.out.println("User name");
		
		String name=ValidatorClass.getValidatedName();
		System.out.println("Password");
		String pasword = ValidatorClass.getValidPassWord();

		try {


			String userloginQurry = "select user_id from user_details\n" + "where user_name= ? and user_pass= ? ;";

			PreparedStatement preparedStatement = new ValidatorClass().getPreparedStatement(userloginQurry);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pasword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getInt("user_id") != 0) {
					System.out.println();
					System.out.println("!!! Login Sucessfull !!!");
					System.out.println();
					int userId = resultSet.getInt("user_id");
					this.userLoginMenu(userId);
				} else {
					System.out.println();
					System.out.println("!!! Invalid login !!!");
					System.out.println();
				}
			} else {
				System.out.println();
				System.out.println("!!! Invalid login !!!");
				System.out.println();
			}
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void userLoginMenu(int userId) {

		boolean isExit = true;

		try {
			while (isExit) {
				System.out.println();
				System.out.println(" ** Welcome to User login **");
				System.out.println();
				System.out.println("Enter 1 to Raise ticket");
				System.out.println("Enter 2 to View ticket");
				System.out.println("Enter 3 to Update ticket");
				System.out.println("Enter 4 to Exit");
				System.out.println();

				switch (ValidatorClass.getValidatedChoice()) {
				case 1:
					new Raiseticket().userTicketRaiser(userId);
					break;

				case 2:
					new ViewTicketDetails().userTicketViewerMenu(userId , false);
					break;

				case 3:
					new Raiseticket().updateUserTicketDetails(userId);
					break;

				case 4:
					isExit = false;
					break;

				default:
					System.out.println();
					System.out.println("!!! Invalid Choice !!!");
					System.out.println();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
