package com.exam.students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.exam.validator.*;
import com.exam.dbconnection.*;


public class StudentCreation extends UserCreationMethods {

	protected String studentName;
	protected byte studentAge;
	protected String studentPassword;
	protected String studentMobileNo;
	protected String studentEmailId;
	protected float examScore=0;
	protected String studentQuota;
	
	
	public void studentCreation() {
		Scanner scanner=new Scanner(System.in);
			
			System.out.println();
			System.out.println("\t"+"\t"+"\t"+"   ** WELCOME TO STUDENT CREATION **");
			System.out.println();
			
			try {

						this.studentName=nameCreation();

						this.studentAge=ageCreator();

						this.studentQuota=quotaCreator();
						
						this.studentMobileNo=mobileNoCreator();
					
						this.studentPassword=passwordCreator();
		
						byte quotaId=quotaIdGenerator(this.studentQuota);
						
						//DB INTEGRATION
						
						
						Connection connection=DBConnection.getInstance().getConnection();
						Statement statement=connection.createStatement();
						
						
						ResultSet resultSet = statement.executeQuery("select count(*) as count\n"
								+ "from student_details\n"
								+ "where (student_name='"+this.studentName+"' and student_password='"+ this.studentPassword+"') or mobile_no=' "+this.studentMobileNo
								+"';");
						
						while(resultSet.next()) {
							if(resultSet.getInt("count") == 1) {
								System.out.println();
								System.out.println("\t"+"\t"+"\t"+"!!! YOUR PASSWORD ALREADY MATCH WITH SAME USER NAME !!!");
								System.out.println();
								System.out.println("\t"+"\t"+"\t\t"+"!!! TRY WITH DIFFERENT !!!");
								System.out.println("\t"+"\t"+"\t"+"************************************************");
								System.out.println();
								
							}
							
							else {
								statement.executeUpdate("insert into student_details(student_name,student_password,age,quota,mobile_no)\n"
										+ "values\n"
										+ "('"+this.studentName+"','"+this.studentPassword+"',"+this.studentAge+","+quotaId+",'"+this.studentMobileNo+"');");
								
								
								ResultSet resultSet1 = statement.executeQuery("select student_id\n"
										+ "from student_details\n"
										+ "where student_name='"+this.studentName+"' and student_password='"+ this.studentPassword+"';");
								
								while(resultSet1.next()) {
									System.out.println();
									System.out.println("\t"+"\t"+"\t"+"!!! Remember your studentId and studentPassword !!!");
									System.out.println("\t"+"\t"+"\t"+"************************************************");
									System.out.println("\t"+"\t"+"\t"+"Your StudentId : "+resultSet.getInt("student_id"));
									System.out.println("\t"+"\t"+"\t"+"Your StudentPassword :"+this.studentPassword);
									System.out.println("\t"+"\t"+"\t"+"!!!! Student user created sucessfully !!!!");
									System.out.println("\t"+"\t"+"\t"+"************************************************");
									System.out.println();
								}
								resultSet1.close();
								
							}
							
						}
						
						resultSet.close();
						statement.close();
						connection.close();

					
				} catch (Exception e) {
					System.out.println("\t"+"\t"+"\t"+"\t"+" ** INVALID INPUT ** ");
					System.out.println(e.getMessage());
					System.out.println();
					
			}
				

		}
	
	private byte quotaIdGenerator(String studentQuota) {
		if(studentQuota.equals("OC")) {
			return 1;
		}
		else if(studentQuota.equals("BC")) {
			return 2;
		}
		else if(studentQuota.equals("OC")) {
			return 3;
		}
		else {
			return 4;
		}
	
}

	
	
}
