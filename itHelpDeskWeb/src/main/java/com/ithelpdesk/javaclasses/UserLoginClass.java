package com.ithelpdesk.javaclasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginClass {
	
	public int getUserDetails(String name,String password) throws SQLException {
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		if(validatorClass.getValidatedName(name) && validatorClass.getValidPassWord(password)) {
			
			return getUserId(name,password);

		}
		
		else {
			return -1;
		}
	}

	private int getUserId(String name, String password) throws SQLException {
		
		ValidatorClass validatorClass=new ValidatorClass();
		
		String getUserIdQuery="select user_id from user_details\n"
				+ "where user_name=? and user_pass= ?;";
		
		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(getUserIdQuery);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			return resultSet.getInt(1);
		}
		else {
			
			return 0;
		}
		
		
	}

	public boolean userIsAdmin(int userId) throws SQLException {
		
		ValidatorClass validatorClass=new ValidatorClass(); 
		
		String isAdminQuery="select is_technician from user_details\n"
				+ "where user_id= ?;";
		
		PreparedStatement preparedStatement=validatorClass.getPreparedStatement(isAdminQuery);
		
		preparedStatement.setInt(1, userId);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.next();
		
		return resultSet.getBoolean(1);
	}

}
