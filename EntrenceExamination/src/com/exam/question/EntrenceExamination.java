package com.exam.question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.exam.dbconnection.*;

public class EntrenceExamination {
	
	String optionSelceted;
	
	public void entrenceExam(long studentId) throws SQLException {
		
		Scanner scanner=new Scanner(System.in);
		
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		
		System.out.println("\t"+"\t"+"\t"+"**************************************");
		System.out.println("\t"+"\t"+"\t"+"         WELCOME TO EXAMINATION ");
		System.out.println("\t"+"\t"+"\t"+"---------------------------------------");
		System.out.println();
		System.out.println("\t"+"Plese read a Question and select a correct option for the question :");
		System.out.println();
		
		ResultSet resultSet=statement.executeQuery("select * from question_table where question_status = true ; ");
		
		if(resultSet != null) {
		
			while(resultSet.next()) {
			
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question NO : "+resultSet.getInt("question_No"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question : "+resultSet.getString("question"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Question score : "+resultSet.getInt("question_Score"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option A : "+resultSet.getString("option_A"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option B : "+resultSet.getString("option_B"));
				System.out.println("\t"+"\t"+"\t"+"\t"+"Option C : "+resultSet.getString("option_C"));
				
				System.out.println();
				
				System.out.println("\t"+"Enter your Answer as A , B ,C");
				
				
				this.optionSelceted=scanner.nextLine().toUpperCase();
				
				boolean isExit=true;
				Statement statement1=connection.createStatement();
				while(isExit) {
					if(optionSelceted.equals("A") || optionSelceted.equals("B") || optionSelceted.equals("C")) {
						
						int option=optionSelceted.equals("A") ? 1 : optionSelceted.equals("B") ? 2 : 3; 
						
						statement1.executeUpdate("insert into examination_table(question_no,student_id,option_selected)\n"
								+ "values("+resultSet.getInt("question_No")+","
								+studentId+","
								+option+");");
						isExit=false;
											
					}else {
						
						System.out.println("\t"+"\t"+"\t"+"\t"+"!!! ONLY 'A' , 'B' , 'C' IS ACCEPTED !!!");
						System.out.println();
						
					}
				}
				statement1.close();
			
			}
			
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"\t"+"  ** EXAM ENDED SUCESSFULLY **");
			System.out.println();
			System.out.println("\t"+"\t"+"*************************************************************************************");
		
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
