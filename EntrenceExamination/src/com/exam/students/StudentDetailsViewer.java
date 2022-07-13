package com.exam.students;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.exam.dbconnection.*;
import com.exam.interfaces.*;


public class StudentDetailsViewer  implements ExaminationInterface  {

	@Override
	public void detailsViewer() throws SQLException{
		Connection connection=DBConnection.getInstance().getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet= statement.executeQuery("select sd.student_id,sd.student_name,sd.student_password,sd.age,qt.quota\n"
				+ "				from student_details as sd\n"
				+ "				inner join quota_table as qt on qt.quota_id = sd.quota");
		
		if(resultSet != null) {
			while(resultSet.next()) {
				
				System.out.println();
				System.out.println("\t"+"\t"+"*************************************************************************************");
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"*Candidate ID : "+resultSet.getLong("student_id"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"*Candidate name : "+resultSet.getString("student_name"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"*Candidate Age : "+resultSet.getString("age"));
				System.out.println();
				System.out.println("\t"+"\t"+"\t"+"\t"+"*Candidate quota : "+resultSet.getString("quota"));
				System.out.println();
				System.out.println("\t"+"\t"+"*************************************************************************************");
				
			}
		}
		else {
			System.out.println("\t"+"\t"+"\t"+"\t"+"** NO STUDENT DETAILS AVAIABLE **");
			System.out.println();
		}
		resultSet.close();
		statement.close();	
		connection.close();
		
	}

	@Override
	public void resultViewer() throws SQLException {
		
	}

}
