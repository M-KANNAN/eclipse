package com.exam.result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.adminusers.*;
import com.exam.dbconnection.*;
public class QuotaBasedResult {
	
	public void quotaBasedresult() throws SQLException {
		
		
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select qt.quota,qs.seats,qt.quota_id  from quota_seats as qs\n"
				+ "inner join quota_table as qt on qt.quota_id = qs.quota_id\n"
				+ "where qt.quota_id = qs.quota_id;");
		
		while(resultSet.next()) {
			
			System.out.println("\t"+"\t"+"\t"+"****************************************************");
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"\t"+"  ** QUOTA  **     "+resultSet.getString("quota"));
			System.out.println();
			
			
			Statement statement2=connection.createStatement();
				
			ResultSet resultSet2=statement2.executeQuery("select sd.student_id, sd.student_name,sd.age,rt.score,sd.quota from result_table as rt\n"
					+ "inner join student_details as sd on sd.student_id = rt.id_student\n"
					+ "where sd.student_id = rt.id_student and sd.quota = "+resultSet.getInt("quota_id")+" \n"
					+ "order by rt.score desc,sd.student_name asc limit "+resultSet.getInt("seats")+";");
			
			
			while(resultSet2.next()) {
				
				if(resultSet2.getInt("score") >= (int)Adminlogin.scoreLimit) {
					System.out.println("\t"+"\t"+"\t"+"****************************************************");
					System.out.println("\t"+"\t"+"\t"+"\t"+"Student Name : "+resultSet2.getString("student_name"));
					System.out.println("\t"+"\t"+"\t"+"\t"+"Student Id :"+resultSet2.getInt("student_id"));
					System.out.println("\t"+"\t"+"\t"+"\t"+"Student Quota :"+resultSet.getString("quota"));
					System.out.println("\t"+"\t"+"\t"+"\t"+"Student score :"+resultSet2.getInt("score"));
					System.out.println("\t"+"\t"+"\t"+"****************************************************");
					System.out.println();
				}
				
				
			}
			resultSet2.close();
			statement2.close();
			
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
	}

}
