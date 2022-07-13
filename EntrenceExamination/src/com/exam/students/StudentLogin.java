package com.exam.students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.exam.dbconnection.*;
import com.exam.validator.*;
import com.exam.adminusers.*;
import com.exam.result.*;
import com.exam.question.*;

public class StudentLogin extends UserCreationMethods{
	
	
public void studentLogin() {
		
		Scanner scanner=new Scanner(System.in);
		
		boolean isExite=true;
		while(isExite) {
			
			try {
				
				System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO STUDENT LOGIN ** ");
				System.out.println();
				
				long studentId=NumberBasedValidator.idValidator(9);
				System.out.println("\t"+"Enter your StudentPassword ");
				String studentPassword=passwordCreator();
				
				//DB INTEGRATION
				
				Connection connection=DBConnection.getInstance().getConnection();
				Statement  statement=connection.createStatement();
				
				ResultSet resultSet=statement.executeQuery("select student_id,student_password,student_name\n"
						+ "FROM student_details;");
				
				if(resultSet != null) {
					
					while(resultSet.next()) {
						if(resultSet.getLong("student_id") == studentId && resultSet.getString("student_password").equals(studentPassword)) {
							System.out.println("\t"+"\t"+"\t"+"!!! LOGIN SUCESSFULLY!!!");
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+" ** WELCOME  "+resultSet.getString("student_name")+" **" );
							System.out.println();
							this.studentMenu(studentId);
							isExite=false;
						}
					}
					
				}
				else {
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"\t"+"!!! RESULT SET IS EMPTY !!!");
					System.out.println();
					System.out.println();
					isExite=false;
				}
				
				if(isExite = true) {
					System.out.println("\t"+"\t"+"\t"+"\t"+"!!! INVALID USER !!!");
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!!");
					System.out.println("\t"+"\t"+"\t"+"****************************************************");
					System.out.println();
					isExite=false;
				}
				
				resultSet.close();
				statement.close();
				connection.close();
				
				
			} catch (Exception e) {
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"!!! INVALID INPUT !!!");
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!!");
				System.out.println("\t"+"\t"+"\t"+"****************************************************");
				System.out.println();
				isExite=false;
			}
			
		}
		
	}


private void studentMenu(long studentId) throws SQLException {
	
	
	

	Scanner scanner=new Scanner(System.in);
	boolean isExite=true;
	while(isExite) {
	
		try {
			System.out.println();
			System.out.println("\t"+"\t"+"\t\t"+"  ** WELCOME TO STUDENT MENU **");
			System.out.println("\t"+"\t\t"+"`Enter 1 to Enter a Test");
			System.out.println("\t"+"\t\t"+"`Enter 2 to check result");
			System.out.println("\t"+"\t\t"+"`Enter 3 to exit ");
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"****************************************************");
			System.out.println();
			
			byte choice=NumberBasedValidator.choiceChecker();
			
				switch (choice) {
				case 1:{
					
					Connection connection=DBConnection.getInstance().getConnection();
					Statement statement=connection.createStatement();
				
					
					ResultSet resultSet=statement.executeQuery("select count(*) as count from examination_table\n"
							+ "where student_id ="+studentId+" ;");
					
					
					while(resultSet.next()) {
						
						if(resultSet.getInt("count") == 0) {
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"****************************************************");
							System.out.println("\t"+"\t"+"\t"+"\t"+"YOU ARE REDIRECTED TO EXAM ");
							new EntrenceExamination().entrenceExam(studentId);
							System.out.println();
							break;	
						}
						else {
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"\t"+"!!! YOU ARE NOT ALLOWED TO ENTER A EXAM !!!");
							System.out.println();
							isExite=false;
							break;
						}
					
					}
					resultSet.close();
					statement.close();
					connection.close();
					break;
				}
				case 2:{
					if(Adminlogin.resultPublished == true) {
						new OverAllResultViewer().detailsViewer(); //
						break;
					}
					else {
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"\t"+" !!! RESULT NOT YET PUBLISHED !!!");
						System.out.println();
						break;
					}
					
				}
				case 3:{
					System.out.println("\t"+"\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!! ");
					System.out.println("\t"+"\t"+"\t"+"****************************************************");
					System.out.println();
					isExite=false;
					break;
				}
				default:{
					System.out.println("\t"+"\t"+"\t"+"\t"+"!!! INVALID CHOICE !!!");
					System.out.println();
					break;
				}
				
					
				}

				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
			System.out.println();
			this.studentMenu(studentId);
		}

	}
	

}
	

}
