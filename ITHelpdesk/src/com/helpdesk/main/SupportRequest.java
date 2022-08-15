package com.helpdesk.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;



import com.helpdesk.dbconnection.DBConnection;

public class SupportRequest {
	
	

	public void userSupportRequest(int userId) throws SQLException {
		Scanner scanner=new  Scanner(System.in);
		
		System.out.println("Enter a subject");
		String subject=scanner.nextLine();
		
		System.out.println("Enter a discription");
		String discription=scanner.nextLine();
		
		Connection connection = DBConnection.getInstance().getConnection();

		PreparedStatement preparedStatement=connection.prepareStatement("insert into ticket_details(user_id,subject,discription,time_creation,status_Id)\n"
				+ "values\n"
				+ "(?,?,?,?,?);");
		
		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, discription);
		preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(5, 1);
		preparedStatement.executeUpdate();
		
		
		Statement statement=connection.createStatement();
		ResultSet  resultSet=statement.executeQuery("select count(*) as count from ticket_details;");
		
		if(resultSet.next()) {
			System.out.println("Your reqest Id : "+resultSet.getInt("count"));
		}
		

		resultSet.close();
		
		preparedStatement.close();
		connection.close();
		
		
	}

	public void adminSupportRequest(int userId) throws SQLException {
		
		
		Scanner scanner=new  Scanner(System.in);
		
		Connection connection = DBConnection.getInstance().getConnection();
		
		
		System.out.println("Enter a subject");
		String subject=scanner.nextLine();
		
		System.out.println("Enter a discription");
		String discription=scanner.nextLine();
		
		
		
		Statement statement1=connection.createStatement();
		
		ResultSet resultSet2=statement1.executeQuery("select user_id,user_name from user_details where is_admin;");
		
		System.out.println("!!! Available Admin !!!");
		
		ArrayList<Integer> adminList=new ArrayList<Integer>();
		
		while(resultSet2.next()) {
			
			System.out.print("Admin ID : "+resultSet2.getInt("user_id") +"\t");
			adminList.add(resultSet2.getInt("user_id"));
			System.out.print("Admin name : "+resultSet2.getString("user_name"));
			System.out.println();
		}
		
		resultSet2.close();
		statement1.close();
		
		int adminId=0;
		while(true) {
			System.out.println("Enter a Admin Id");
			adminId=scanner.nextInt();
			
			if(adminList.contains(adminId)) {
				break;
			}
			else {
				System.out.println("Invalid admin");
			}
		}
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into ticket_details(user_id,subject,discription,time_creation,status_Id,admin_id)\n"
				+ "values\n"
				+ "(?,?,?,?,?,?);");
	
		
		preparedStatement.setInt(1, userId);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, discription);
		preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		preparedStatement.setInt(5, 2);
		preparedStatement.setInt(6, adminId);
		
		preparedStatement.executeUpdate();
		
		
		Statement statement=connection.createStatement();
		ResultSet  resultSet=statement.executeQuery("select count(*) as count from ticket_details;");
		
		if(resultSet.next()) {
			System.out.println("Your reqest Id : "+resultSet.getInt("count"));
		}
		
		resultSet.close();
		
		preparedStatement.close();
		connection.close();
		
		
	}


}
