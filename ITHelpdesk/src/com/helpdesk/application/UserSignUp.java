package com.helpdesk.application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignUp {

	public void userSignUp() {
		
		boolean isExite = true;

		while (isExite) {
			System.out.println();
			System.out.println(" ** Welcome UserSignUp **");
			System.out.println();
			System.out.println("Enter your choice ");
			System.out.println();
			System.out.println("Enter 1 to admin Signup");
			System.out.println("Enter 2 to user Signup");
			System.out.println("Enter 3 to exit");
			System.out.println();

			switch (ValidatorClass.getValidatedChoice()) {

			case 1:
				adminVerifiyer();
				break;

			case 2:
				try {
					setUserDetails(false);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;

			case 3:
				isExite = false;
				
				break;

			default:
				break;

			}
		}
		
	}

	private void adminVerifiyer() {
		
		System.out.println();
		System.out.println("!!! Verify your admin status !!!");
		System.out.println();
		System.out.println("Enter Admin username :");
		String adminUserName=ValidatorClass.getValidatedName();
		String adminPassWord=ValidatorClass.getValidPassWord();
		
		if("sysadmin".equals(adminUserName) && "sysadmin@".equals(adminPassWord)) {
			System.out.println(" !!!Admin status verification Sucessfull !!!");
			System.out.println();
			try {
				setUserDetails(true);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		else {
			System.out.println();
			System.out.println(" !!! Only admin users are able to login !!!");
			System.out.println();
		}
		
		
	}

	private void setUserDetails(boolean isAdmin) throws SQLException {
		
		System.out.println();
		System.out.println("Enter a UserName :");
		String userName=ValidatorClass.getValidatedName();
		System.out.println("Enter a UserPassWord");
		String userPassword=ValidatorClass.getValidPassWord();
		
		String checkUserAvailabilityQuery="select count(*) as count from user_details\n"
				+ "where user_name ilike ? ;";
		
		
		
		PreparedStatement preparedStatement=new ValidatorClass().getPreparedStatement(checkUserAvailabilityQuery);
		
		preparedStatement.setString(1, userName);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		
		if(resultSet.next()) {
			if(resultSet.getInt(1) == 0) {
				
				String insertUserQuery="insert into user_details(user_name,user_pass,is_admin)\n"
						+ "VALUES\n"
						+ "(?,?,?) RETURNING *;";
				
				preparedStatement=new ValidatorClass().getPreparedStatement(insertUserQuery);
				
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userPassword);
				preparedStatement.setBoolean(3, isAdmin);
				
				preparedStatement.execute();
				
				ResultSet resultSet1=preparedStatement.getResultSet();
				resultSet1.next();
				System.out.println();
				System.out.println("!!! Your User Id is : " + resultSet1.getInt(1) +" !!!");
				System.out.println();
				
				resultSet1.close();
				
			}
			else {
				System.out.println();
				System.out.println("!!! User Name unavailable !!!");
				System.out.println();
			}
		}
		else {
			System.out.println();
			System.out.println(" !!! Resultset is empty !!!");
			System.out.println();
		}
		

		resultSet.close();
		preparedStatement.close();
		
	}

}
