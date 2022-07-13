package com.exam.question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.exam.validator.*;
import com.exam.dbconnection.*;


public class ExamQuestionPaper {

	protected long adminIdforQuestion;
	protected String question;
	protected String optionA;
	protected String optionB;
	protected String optionC;
	protected String correctOption;
	protected float questionScore;
	protected boolean status;
	
	
	
	public void questionPaper(long adminId) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		boolean isExite=true;
		while(isExite) {
			
			try {
				
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"  ** QUESTION MENU **");
				System.out.println("\t"+"\t"+"Do you want to add the Question ");
				System.out.println("\t"+"\t"+"Type '1' to insert Question");
				System.out.println("\t"+"\t"+"Type 2 to modify the question");
				System.out.println("\t"+"\t"+"Type 3 to exit");
				System.out.println();
				
				
				
				byte choice=NumberBasedValidator.choiceChecker();
					
					
					switch(choice) {
					case 1 :
						
						this.QuestionSetter(adminId);
						break;
					
					case 2 :
						this.quesrtionUpdater();
						break;
					
					case 3 :
						System.out.println("\t"+"\t"+"\t"+"\t"+"!!! REDIRECTING TO ADMIN LOGIN !!!");
						isExite=false;
						break;
					 
					default :
						System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
						isExite=false;
						this.questionPaper(adminId);
						break;
					
						
				}
					
				
			} catch (InputMismatchException e) {
				System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
				System.out.println();
				this.questionPaper(adminId);
			}	
			
			
		}
			
		
	}
	
	
	

	private void quesrtionUpdater() throws SQLException {
	
		Scanner scanner=new Scanner(System.in);
		System.out.println("\t"+"\t"+"\t"+"\t"+"  ** WELCOME TO QUESTION UPDATE MENU ** ");
		System.out.println();
		
		
		int updateNumber=NumberBasedValidator.questionNumberChecker();
		

		
		//DB INTEGRATION
		
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from question_table\n"
				+ "where question_no="+updateNumber+"; ");
		
		if(resultSet != null) {
			
			while(resultSet.next()) {
				
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"  ** QUESTION TO BE UPDATED **");
				System.out.println();
				
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question NO : "+resultSet.getInt("question_No"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question : "+resultSet.getString("question"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question score : "+resultSet.getInt("question_Score"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option A : "+resultSet.getString("option_A"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option B : "+resultSet.getString("option_B"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option C : "+resultSet.getString("option_C"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Correct option : "+resultSet.getInt("correct_Option"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question Status : "+resultSet.getBoolean("question_status"));
				System.out.println();
				
			}
			
			
			boolean isExite=true;
			while(isExite) {
				
				
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"  ** SELECT THE VALUE TO BE UPDATED **");
				System.out.println("\t"+"1 to update a mistake in a question ");
				System.out.println("\t"+"2 to update the question score  ");
				System.out.println("\t"+"3 to update option A ");
				System.out.println("\t"+"4 to update Option B");
				System.out.println("\t"+"5 to update Option c");
				System.out.println("\t"+"6 to correct option ");
				System.out.println("\t"+"7 to update the status of the question status");
				System.out.println("\t"+"8 to exit");
				System.out.println();
				
				
				byte choice=NumberBasedValidator.choiceChecker();
					
					switch(choice) {
					
					
					case 1: {
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set  question  = '"+ QuestionPaperMethods.questionAndOptionSetter("Question") +"'\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
					}
						
					case 2 :{
						
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set  question_score  = "+ (int)QuestionPaperMethods.scoreSetter() +"\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
						
					}
					case 3 :{
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set   option_a  = '"+ QuestionPaperMethods.questionAndOptionSetter("option A") +"'\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
					}
					
					case 4 :{
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set   option_b  = '"+ QuestionPaperMethods.questionAndOptionSetter("option B") +"'\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
					}
					case 5 :{
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set   option_c  = '"+ QuestionPaperMethods.questionAndOptionSetter("option C") +"'\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
					}
					
					case 6 :{
						String correctString =QuestionPaperMethods.correctOptionSetter();
						
						Statement statement2=connection.createStatement();
						int val=correctString.equals("optiona") ? 1 : correctString.equals("optionb") ? 2 : 3;
						statement2.executeUpdate("update question_table\n"
								+ "set  correct_option   = '"+  val  +"'\n"
								+ "where question_no="+updateNumber+";");
						statement2.close();
						break;
						
					}
					
					case 7 :{
						
						Statement statement2=connection.createStatement();
						statement2.executeUpdate("update question_table\n"
								+ "set question_status  = "+ QuestionPaperMethods.statusSetter() +"\n"
								+ "where question_no="+updateNumber+";"); 
						statement2.close();
						break;
						
						
					}
					
					case 8:{
						System.out.println("\t"+"\t"+"\t"+"\t"+" !!! REDIRECTING TO QUESTION MENU !!!");
						System.out.println();
						isExite=false;
						break;
					}
					default :{
						System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
						System.out.println();
						break;
					}
			
				}
			
			}
			
		}
		
		else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"!!! NO QUESTION FOUND !!!");
			System.out.println();
		}
		
		
		
		
	}
	
	
	
private void QuestionSetter(long adminId) {
		
			
			try {
	
					
					question=QuestionPaperMethods.questionAndOptionSetter("Question");	
					
					
					questionScore=QuestionPaperMethods.scoreSetter();
					
					
					optionA=QuestionPaperMethods.questionAndOptionSetter("option A");
					
					
					optionB=QuestionPaperMethods.questionAndOptionSetter("option B");

			
					optionC=QuestionPaperMethods.questionAndOptionSetter("option C");
					

					correctOption=QuestionPaperMethods.correctOptionSetter();
					
					int option=correctOption.equals("optiona") ? 1 : correctOption.equals("optionb") ? 2 : 3;
					System.out.println("Option :"+option);
					

					status=QuestionPaperMethods.statusSetter();
					
					
					Connection connection=DBConnection.getInstance().getConnection();
					Statement statement=connection.createStatement();
					
					
					statement.executeUpdate("insert into question_table(question,option_A,option_B,option_C,correct_Option,question_Score,question_status)\n"
							+ "values('"+this.question+"','"+this.optionA+"','"+this.optionB+"','"+this.optionC+"',"+option+
							","+this.questionScore+","+this.status+");");
					
					statement.close();
					connection.close();
					
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("\t"+"\t"+"\t"+"\t"+"!!! IVALID INPUT !!!");
				System.out.println();
		
			}

	}
	
	
}
