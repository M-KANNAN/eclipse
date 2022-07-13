package com.exam.result;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.dbconnection.*;
import com.exam.interfaces.*;

public class OverAllResultViewer implements ExaminationInterface{
	

	@Override
	public void detailsViewer() throws SQLException {
		
	Connection connection=DBConnection.getInstance().getConnection();
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select count(*) as count\n"
				+ "from question_table;");
		int questionCount=0;
		
		while(resultSet.next()) {
			questionCount=resultSet.getInt("count");
		}
		
		System.out.println("Question count : "+questionCount);
		
		Statement statement1=connection.createStatement();
		ResultSet resultSet1=statement1.executeQuery("select student_id,student_name\n"
				+ "FROM student_details;");
		
		if(!resultSet1.wasNull()) {
			
			while(resultSet1.next()) {
				
				Statement statement2=connection.createStatement();
				ResultSet resultSet2=statement2.executeQuery("select sum(qt.question_score) as score ,count (*) as count from examination_table as et\n"
						+ "inner join question_table as qt on qt.question_no = et.question_no\n"
						+ "where et.option_selected = qt.correct_option and et.student_id = "+resultSet1.getInt("student_id")+" ;");
				
				while(resultSet2.next()) {
					int score=resultSet2.getInt("score") + (questionCount - resultSet2.getInt("count") )*(-1);
					
					Statement statement3=connection.createStatement();
					
					ResultSet resultSet4=statement3.executeQuery("select id_student from result_table \n"
							+ "where id_student="+resultSet1.getInt("student_id")+";");
					if(!resultSet4.next()) {
						statement3.executeUpdate("insert into result_table(id_student,score)\n"
								+ "values\n"
								+ "("+resultSet1.getString("student_id")+","+score+");");
						
						
					}
					else {
						System.out.println("\t"+"\t"+"\t"+"!!! USER FOUND IN DB !!!");
						System.out.println();
						System.out.println("\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!!");
						System.out.println();
					}
					resultSet4.close();
					statement3.close();
					
				}
				statement2.close();
				resultSet2.close();
				
			}
			resultSet1.close();
			statement1.close();

		}
		else {
			System.out.println("\t"+"\t"+"\t"+"!!! RESULT SET IS NULL !!!");
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"!!! REDIRECTING TO LOGIN PAGE !!!");
			System.out.println();
			
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		this.resultViewer();
		
		
	}

	@Override
	public void resultViewer() throws SQLException {
	Connection connection=DBConnection.getInstance().getConnection();
		
		System.out.println("\t"+"\t"+"*************************************************************************************");
		System.out.println("\t"+"\t"+"\t"+"             		OVERALL RESULT                  ");
		System.out.println();
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select sd.student_id,sd.student_name,sd.age,rs.score from student_details as sd\n"
				+ "inner join result_table as rs ON rs.id_student = sd.student_id\n"
				+ "order by rs.score desc,sd.student_name asc;");
		
		
		while(resultSet.next()) {
			
			
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"****************************************************");
			System.out.println("\t"+"\t"+"\t"+"\t"+"Student Name : "+resultSet.getString("student_name"));
			System.out.println("\t"+"\t"+"\t"+"\t"+"Student Id :"+ resultSet.getInt("student_id"));
			System.out.println("\t"+"\t"+"\t"+"\t"+"Student score :"+resultSet.getInt("score"));
			System.out.println("\t"+"\t"+"\t"+"****************************************************");
			System.out.println();
			
			
		}
		resultSet.close();
		statement.close();
		connection.close();
		
	}

}
