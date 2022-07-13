package com.exam.adminusers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.exam.validator.*;
import com.exam.dbconnection.*;



public class AdminCreation extends UserCreationMethods{

	protected String adminName;
	protected String adminPassword;
	
	
public void adminCreation()  throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		
			System.out.println();
			System.out.println("\t"+"\t"+"Please provide a ExaminationController user name and password :");
			System.out.println();
			System.out.println("\t"+"Enter a Examinationcontroller username :");
			String Name=nameCreation();
			System.out.println();
			System.out.println("\t"+"Enter the Examinationcontroller password :");
			String Password=scanner.nextLine();
			
			if(Name.equals("Admin") && Password.equals("Admin")) {
	
					try {
						

							boolean isExit=true;
							
							while(isExit) {
								System.out.println("\t"+"\t"+"\t"+"************************************");
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO ADMIN CREATION**");
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"************************************");
								System.out.println("\t"+"\t\t"+"Enter 1 to add admin ");
								System.out.println("\t"+"\t\t"+"Enter 2 to view admin users");
								System.out.println("\t"+"\t\t"+"Enter 3 to delete admin users");						
								System.out.println("\t"+"\t\t"+"Enter 4 to delete all ExamDetails");
								System.out.println("\t"+"\t\t"+"Enter 5 to exit");
								System.out.println();
								
								byte choice=NumberBasedValidator.choiceChecker();
								
								switch(choice) {
								
								case 1 :
									this.newAdminCreation();
									break;
									
								case 2 :
									this.adminViewer();
									break;
								
								case 3 :
									this.adminTruncator();
									break;
									
								case 4 :
									this.examTruncator();
									break;
								
								case 5 :
									isExit=false;
									System.out.println("\t"+"\t"+"\t"+"!!! REDIRECTING TO CREATION MENU!!!");
									System.out.println("\t"+"\t"+"\t"+"************************************");
									System.out.println();
									break;
								default :
									System.out.println("\t"+"\t"+"\t"+"!!!  TYPE VALID CHOICE!!!");
									System.out.println();
									break;
									
								
								}
								
								
							}
							
							
						} catch (Exception e) {
						System.out.println("\t"+"\t"+"\t"+"!!! INVALID INPUT !!!");
						System.out.println(e.getMessage());
						System.out.println();
						this.adminCreation();
					}

			}
			else {
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"!!! ONLY ADMIN USERS ARE ALLOWED !!!");
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"!!! REDIRECTING TO HOMEPAGE !!!");
				System.out.println("\t"+"\t"+"\t"+"************************************");
				System.out.println();
			}
	
		
	
	}

	private void examTruncator() throws SQLException {
		
		Connection connection=DBConnection.getInstance().getConnection();
		
		Statement statement=connection.createStatement();
		
		//STUDENT TABLE
		statement.executeUpdate("truncate table student_details CASCADE;");
		statement.executeUpdate("alter SEQUENCE student_details_student_id_seq restart with 100000001;");
		
		//EXAMINATION TABLE
		statement.executeUpdate("truncate table examination_table CASCADE;");
		
		//EXAM CONSTRAINS TABLE
		statement.executeUpdate("update exam_condition\n"
				+ "set constraints_flag =false\n"
				+ "where exam_constraints='quotaDivided';");
		statement.executeUpdate("update exam_condition\n"
				+ "set constraints_flag =false\n"
				+ "where exam_constraints='startTest';");
		statement.executeUpdate("update exam_condition\n"
				+ "set constraints_flag =false\n"
				+ "where exam_constraints='resultPublished';");
		
		
		//QUOTASEATS TABLE
		statement.executeUpdate("update quota_seats\n"
				+ "set seats=0\n"
				+ "where quota_id=1;");
		statement.executeUpdate("update quota_seats\n"
				+ "set seats=0\n"
				+ "where quota_id=2;");
		statement.executeUpdate("update quota_seats\n"
				+ "set seats=0\n"
				+ "where quota_id=3;");
		statement.executeUpdate("update quota_seats\n"
				+ "set seats=0\n"
				+ "where quota_id=4;");
		
		//Question table
		statement.executeUpdate("truncate question_table CASCADE;");
		statement.executeUpdate("Alter SEQUENCE question_table_question_no_seq restart with 1;");
		
		//RESULT TABLE
		statement.executeUpdate("truncate result_table CASCADE;");
		
		//EXAM TABLE
		statement.executeUpdate("truncate examination_table;");
		
		
		
		System.out.println();
		System.out.println("\t\t\t ** ALL EXAM DATA IS DELETED **");
		System.out.println("\t"+"\t"+"\t"+"************************************");
		System.out.println();
		connection.close();
		statement.close();
		
		
	}

	private void adminTruncator() throws SQLException {
		
		
		Connection connection=DBConnection.getInstance().getConnection();
		//System.out.println("Connection established "+connection);
		Statement statement=connection.createStatement();
		statement.executeUpdate("truncate table admin_table;");
		statement.executeUpdate("ALTER SEQUENCE admin_table_admin_id_seq RESTART WITH 10001;");
		System.out.println();
		System.out.println("\t\t\t ** ADMIN USERS DELETED SUCESSFULLY **");
		System.out.println("\t"+"\t"+"\t"+"************************************");
		System.out.println();
		connection.close();
		statement.close();
		
		
	}

	private void adminViewer() throws SQLException {
		
		Connection connection=DBConnection.getInstance().getConnection();
		//System.out.println("Connection established "+connection);
		Statement statement=connection.createStatement();
		System.out.println("\t\t\t\t  ** ADMIN USERS **");
		System.out.println("\t\t\t\t ADMIN_ID | USER_NAME  ");
		System.out.println();
		ResultSet resultSet= statement.executeQuery("Select admin_id ,user_name FROM admin_table;");
		while(resultSet.next()) {
			System.out.println("\t\t\t\t "+ resultSet.getInt("admin_id") +"    |    " + resultSet.getString("user_name")); 
			
		}
		System.out.println("\t"+"\t"+"\t"+"************************************");
		
		System.out.println();
		resultSet.close();
		connection.close();
		statement.close();;
		
	}

	private void newAdminCreation() throws SQLException {
		
		
		Connection connection=DBConnection.getInstance().getConnection();

		Statement statement=connection.createStatement();
		
		this.adminName = nameCreation().toUpperCase();
		
		this.adminPassword=passwordCreator();
		
			 statement.executeUpdate("insert into admin_table(user_name,admin_password)\n"
					+ "values\n"
					+ "('"+ this.adminName+"','"+ this.adminPassword+"');");
			System.out.println("\t"+"\t"+"\t"+" !!! ADMIN ADDED TO DATABASE!!!");
			System.out.println();
			
			ResultSet  resultSet=statement.executeQuery("select *  from admin_table\n"
			+ "where user_Name='"+this.adminName+ "'and admin_password = '"+ this.adminPassword+ "';");
			
			while(resultSet.next()) {
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"!!! Remember your AdminId and AdminPAssword !!!");
				System.out.println("\t"+"\t"+"\t"+"************************************************");
				System.out.println("\t"+"\t"+"\t"+"\t"+"Your AdminId : "+resultSet.getInt("admin_Id"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Your AdminPassword :"+resultSet.getString("admin_password"));
				System.out.println("\t"+"\t"+"\t"+"!!!! Admin user created sucessfully !!!!");
				System.out.println("\t"+"\t"+"\t"+"************************************************");
				System.out.println();
			}
			
			connection.close();
			statement.close();

		
	}
	

}
