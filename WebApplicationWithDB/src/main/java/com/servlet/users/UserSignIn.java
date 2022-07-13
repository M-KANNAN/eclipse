package com.servlet.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servlet.DBConnection.*;

public class UserSignIn {
	StringBuilder builder=new StringBuilder();

	public void siginIn(String name, String pass) throws SQLException {
		
		builder.append("create table if not exists login_details(\n"
				+ " 	user_Id serial primary key,\n"
				+ "	user_Name varchar(40) not null ,\n"
				+ "	user_pass varchar(30) not null,\n"
				+ "	unique(user_Name,user_pass)\n"
				+ ");");
		
		PreparedStatement preparedStatement;
		try {
			Connection connection=DBConnection.getInstance().getConnection();
			
			preparedStatement=connection.prepareStatement(builder.toString());
			System.out.println("!! Sucess !!");
			
			builder.setLength(0);
			
			builder.append("insert into login_details(user_name,user_pass)\n"
					+ "values \n"
					+ "(?,?);");
			
			
			preparedStatement=connection.prepareStatement(builder.toString());
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
