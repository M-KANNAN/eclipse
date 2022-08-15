package com.ithelpdesk.javaclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ithelpdesk.dbconnection.*;

public class ValidatorClass {
	
	
	static Connection connection;

	public boolean getValidatedName(String uname) {

		int letterCount = 0;
		int digitCount = 0;
		int underscore_dotCount = 0;

		boolean validator = true;
		
		if(uname.length() < 30 && uname.length() > 4  && !uname.trim().equals("")) {
			
			for (int i = 0; i < uname.length(); i++) {

				if (Character.isDigit(uname.charAt(i))) {
					digitCount++;
				} else if (Character.isAlphabetic(uname.charAt(i))) {
					letterCount++;
				}

				else if (uname.charAt(i) == '_' || uname.charAt(i) == '.')
					underscore_dotCount++;
				else {
					validator = false;

				}

			}
			
		}
		else {
			validator=false;
		}


		if (digitCount > letterCount || underscore_dotCount > letterCount) {
			validator = false;
		}

		if (validator) {
			return true;
		} else {
			return false;
		}

	}

//
	public boolean getValidPassWord(String upass) {

		boolean validator = true;

		if (upass.length() < 30 && upass.length() > 6  && !upass.trim().equals("")) {

			for (int i = 0; i < upass.length(); i++) {

				if (Character.isDigit(upass.charAt(i)) || Character.isAlphabetic(upass.charAt(i))
						|| upass.charAt(i) == '@' || upass.charAt(i) == '_') {
					continue;
				} else {

					validator = false;
					break;
				}

			}

		} else {
			validator = false;
		}

		if (validator) {
			return true;
		} else {
			return false;
		}

	}
	
	
	public boolean subjectDiscriptionValidator(String text ,int choice) {
		
		if(choice ==1) {
			return text.length() > 10 && text.length() < 100  && !"".equals(text.trim());
		}
		else {
			return text.length() > 10 && !"".equals(text.trim());
		}
	}


public PreparedStatement getPreparedStatement(String query) {

		PreparedStatement preparedStatement = null;
		try {

			if (connection == null) {
				connection = DBConnection.getInstance().getConnection();
		
			} else if (connection.isClosed()) {
			
				connection = DBConnection.getInstance().getConnection();
			}

			if(connection != null) {
				preparedStatement = connection.prepareStatement(query);
			}
			else {
				System.out.println();
				
				System.out.println("!!! No Connection !!!");
				System.out.println();
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return preparedStatement;

	}

	public void closeConnection() {

		try {

			if (connection != null) {
				connection.close();
				System.out.println("close");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
