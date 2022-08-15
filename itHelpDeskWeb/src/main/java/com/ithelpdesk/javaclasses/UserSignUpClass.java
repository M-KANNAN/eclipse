package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSignUpClass {
	
	
public boolean getValidatedUser(String name,String pass ,boolean isAdmin) throws SQLException {
		
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		if(validatorClass.getValidatedName(name) && validatorClass.getValidPassWord(pass) && isUserAvailable(name)) {
			
			addUserDetails(name,pass,isAdmin);
			
			return true;
		}
		
		else {
			return false;
		}
		
	}

	private void addUserDetails(String name, String pass, boolean isAdmin) throws SQLException {
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String insertUserQuery="insert into user_details(user_name,user_pass,is_admin)\n"
				+ "VALUES\n"
				+ "(?,?,?) ;";
		
		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(insertUserQuery);
		
		if(preparedStatement != null) {
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			preparedStatement.setBoolean(3, isAdmin);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		
		else {
			System.out.println();
			System.out.println("Prepared statement is null");
			System.out.println();
		}
		

	}

	private boolean isUserAvailable(String name) throws SQLException {
		
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String isUserAvailabeQuery="select count(*) as count from user_details\n"
				+ "where user_name ilike ? ;";
		
		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(isUserAvailabeQuery);
		
		preparedStatement.setString(1, name);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		
		resultSet.next() ;

		boolean isUser=resultSet.getInt(1) == 0;
		
		resultSet.close();
		preparedStatement.close();
		
		return isUser;
		
	}


}
