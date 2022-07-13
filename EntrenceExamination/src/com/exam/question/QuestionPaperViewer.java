package com.exam.question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.exam.dbconnection.*;


public class QuestionPaperViewer {
	
	public static void questionPaperViewer() throws SQLException {
		
		
		System.out.println();
		System.out.println("\t"+"\t"+"\t"+"\t"+"         ** QUESTION PAPER **    ");
		System.out.println();
		
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery("select * from question_table; ");
		
		if(resultSet != null) {
			
			while(resultSet.next()) {
				
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
			
		}
		else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"!!! NO QUESTION FOUND !!!");
			System.out.println();
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
	}
	

}
