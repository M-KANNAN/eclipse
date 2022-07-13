package com.exam.result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.dbconnection.*;
import com.exam.adminusers.*;


public class StudentResultViewer  {


	public void resultViewer(long studentId) throws SQLException {
		// TODO Auto-generated method stub
		
		int scoreCount=0;
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select qt.question_no,qt.question,qt.question_score,qt.option_a,qt.option_b,qt.option_c,ot.question_option as selected_Option,op.question_option as correct_Option\n"
				+ "from question_table as qt\n"
				+ "inner join examination_table as et on et.question_no = qt.question_no\n"
				+ "INNER join option_table as op on op.option_id = qt.correct_option\n"
				+ "INNER Join option_table as ot on ot.option_id = et.option_selected\n"
				+ "where et.student_id = "+studentId+";");
				
		if(!resultSet.wasNull()) {
			
			boolean checker=false;
			
			Statement statement1=connection.createStatement();
			ResultSet resultSet1=statement1.executeQuery("select student_name from student_details\n"
					+ "where student_id = "+studentId+";");
			while(resultSet1.next()) {
				System.out.println("\t"+"\t"+"\t"+"*************************************************************************************");
				System.out.println("\t"+"\t"+"\t"+"\t"+"             	STUDENT   MARKSHEET                   ");
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Candidate ID : "+studentId);
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Canditade name : "+ resultSet1.getString("student_name"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"*************************************************************************************");
				System.out.println();
				
				
			}
			resultSet1.close();
			statement1.close();
			
			while(resultSet.next()) {
				
				checker=true;
				
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Question number :"+resultSet.getInt("question_no"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Question : "+resultSet.getString("question"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Question Score : "+resultSet.getInt("question_score"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Option A : "+resultSet.getString("option_A"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Option B : "+resultSet.getString("option_B"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Option C : "+resultSet.getString("option_C"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Question correct answer : "+resultSet.getString("correct_Option"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"    Answer you have selected : "+resultSet.getString("selected_Option"));
				
				if(resultSet.getString("correct_Option").equals(resultSet.getString("selected_Option"))) {
					
					scoreCount+=resultSet.getInt("question_score");
					System.out.println();
					System.out.println("\t"+"\t"+"\t"+"\t"+"    Your mark for the question is : "+resultSet.getInt("question_score"));
					
				}
				else {
					scoreCount=scoreCount-1;
					System.out.println("\t"+"\t"+"\t"+"\t"+"    Your mark for the question is : -1");
					System.out.println();
				}
				
				System.out.println("\t"+"\t"+"\t"+"-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
				System.out.println();
				
			}
		
			if(!checker) {
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"      YOU HAVEN'T APPEARED FOR A EXAM !!!");
				System.out.println();
			}
			else {
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Candidate score : "+scoreCount);
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"Candidate remarks: "+(scoreCount >= (int) Adminlogin.scoreLimit ? "PASS" : "FAIL"));
				System.out.println("\t"+"\t"+"\t"+"-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
				System.out.println();
			}
			
		}
		else {
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"\t"+"!!! RESULT SET IS EMPTY !!!");
			System.out.println();
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		
		
		
	}

}
