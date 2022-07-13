package com.exam.adminusers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.exam.validator.*;
import com.exam.dbconnection.*;
import com.exam.question.*;
import com.exam.result.*;
import com.exam.students.*;

public class Adminlogin extends UserCreationMethods {

	
	static public  float scoreLimit;
	static public boolean quotaDivided=false;
	static public boolean startTest=false;
	static public boolean resultPublished=false;
	
	public void adminLogin() throws SQLException{
			
				try {
					

					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"  ** WELCOME TO ADMIN LOGIN **");
					System.out.println();
					
					long adminId=NumberBasedValidator.idValidator(5);
					String adminPassword=passwordCreator();
					
					Connection connection=DBConnection.getInstance().getConnection();
					
					Statement statement=connection.createStatement();
					
					ResultSet  resultSet=statement.executeQuery("select * from admin_table\n"
							+ "where admin_id =  "+adminId+";");
					
					if(resultSet != null) {
						
						while(resultSet.next()) {
							if(resultSet.getString("admin_password").equals(adminPassword)) {
								System.out.println();
								
								System.out.println("\t"+"\t"+"\t\t"+" ** Admin Login Successfull **");
								System.out.println();
								System.out.println("\t"+"\t"+"\t\t"+"  ** WELCOME  "+ resultSet.getString("user_Name") +"  **");
								System.out.println();
								
								this.adminMenu(adminId);
								
							}
							else {
								System.out.println("\t"+"\t"+"\t"+"!!! INVALID USER !!!");
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!!");
								System.out.println();
								
							}
							
						}
						resultSet.close();
						
					}
					else {
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"!!! RESULT SET IS NULL !!!");
						System.out.println();
			
						
					}
					statement.close();
					connection.close();
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"!!! ENTER VALID INPUT !!!");
					this.adminLogin();
				}
				
		
	}
	private void adminMenu(long adminId)  throws SQLException{
		Scanner scanner=new Scanner(System.in);

			boolean isExite=true;
			while(isExite) {
				
				
				try {
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"  ** ADMIN MENU **");
					System.out.println("\t"+"\t\t"+"`Enter 1 to Question menu ");
					System.out.println("\t"+"\t\t"+"`Enter 2 to make test start for students");
					System.out.println("\t"+"\t\t"+"`Enter 3 to publish result");
					System.out.println("\t"+"\t\t"+"`Enter 4 to check the applied student details");
					System.out.println("\t"+"\t\t"+"`Enter 5 to check the overall student exam result");
					System.out.println("\t"+"\t\t"+"`Enter 6 to divide seats for quota :");
					System.out.println("\t"+"\t\t"+"`Enter 7 to quota based result :");
					System.out.println("\t"+"\t\t"+"`Enter 8 to view Question paper");
					System.out.println("\t"+"\t\t"+"`Enter 9 to exit ");
					System.out.println();
					
					
						
					byte choice=NumberBasedValidator.choiceChecker();
					
					Connection connection=DBConnection.getInstance().getConnection();
						
						switch (choice) {
						case 1:{
							new ExamQuestionPaper().questionPaper(adminId);
							break;
						}
						case 2:{
							Statement statement=connection.createStatement();
							statement.executeUpdate("update exam_condition\n"
									+ "set constraints_flag =true\n"
									+ "where exam_constraints='startTest';");
							
							 ResultSet resultSet=  statement.executeQuery("select constraints_flag from exam_condition\n"
									+ "where exam_constraints='startTest';");
							 if(resultSet.next()) {
								 this.startTest=resultSet.getBoolean("constraints_flag");
							 }
							 else {
									System.out.println("\t"+"\t"+"\t"+"\t"+" !!! RESULT SET IS EMPTY !!!");
									System.out.println();
							 }
							
							resultSet.close();
							statement.close();
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"!!! TEST is available for students !!!");
							System.out.println();
							break;
						}
						case 3:{
							
							Statement statement=connection.createStatement();
							statement.executeUpdate("update exam_condition\n"
									+ "set constraints_flag =true\n"
									+ "where exam_constraints='resultPublished';");
							
							 ResultSet resultSet=  statement.executeQuery("select constraints_flag from exam_condition\n"
									+ "where exam_constraints='startTest';");
							
							 if(resultSet.next()) {
								 this.resultPublished=resultSet.getBoolean("constraints_flag");
							 }
							 else {
									System.out.println("\t"+"\t"+"\t"+"\t"+" !!! RESULT SET IS EMPTY !!!");
									System.out.println();
							 }
							 
							 resultSet.close();
							 statement.close();
							
							System.out.println();
							System.out.println("\t"+"Enter the Pass limit for the students in Exam :");
							this.scoreLimit=QuestionPaperMethods.scoreSetter();
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"!!! RESULT PUBLISHED !!!");
							System.out.println();
							break;
						}
						case 4:{
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"  ** APPLIED STUDENTS DETAILS **");
							System.out.println();
							new StudentDetailsViewer().detailsViewer();
							break;
						}
						case 5 :{
							
							if(Adminlogin.resultPublished == true) {
								new OverAllResultViewer().detailsViewer();
								break;
							}
							else {
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"  !!! RESULT NOT YET PUBLISHED  !!!");
								System.out.println();
								break;
							}
							
							
						}
						case 6 :{
							new QuotaBasedSeatUpdation().quota();
							
							Statement statement=connection.createStatement();
							statement.executeUpdate("update exam_condition\n"
									+ "set constraints_flag =true\n"
									+ "where exam_constraints='quotaDivided';");
							
							 ResultSet resultSet=  statement.executeQuery("select constraints_flag from exam_condition\n"
									+ "where exam_constraints='startTest';");
							 
							 if(resultSet.next()) {
								 Adminlogin.quotaDivided = resultSet.getBoolean("constraints_flag");
							 }
							 else {
								 System.out.println("\t"+"\t"+"\t"+"\t"+" !!! RESULT SET IS EMPTY !!!");
									System.out.println();
							 }
							
							
							break;
							
						}
						case 7 :{
							
							if(Adminlogin.resultPublished== true && Adminlogin.quotaDivided == true) {
								new QuotaBasedResult().quotaBasedresult();
								break;
							}
							else {
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"  !!! RESULT NOT YET PUBLISHED  !!!");
								System.out.println();
								break;
							}
						}
						
						case 8 :{
							QuestionPaperViewer.questionPaperViewer();
							break;
						}
						
						
						case 9:{
							System.out.println();
							System.out.println("\t"+"\t\t"+"  !!! REDIRECTING TO LOGIN MENU !!!");
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"****************************************************");
							isExite=false;
							break;
						}
						default:{
							System.out.println();
							System.out.println("\t"+"\t"+"\t"+"!!! ENTER THE CORRECT VALUE !!!");
							System.out.println();
							break;
						}
						}

					
				} catch (Exception e) {
					System.out.println("\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
					System.out.println();
					System.out.println(e.getMessage());
					this.adminMenu(adminId);
					break;
				}
			
			
			}
				
		
	}
	
}
