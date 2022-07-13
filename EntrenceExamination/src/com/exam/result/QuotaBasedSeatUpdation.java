package com.exam.result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.exam.dbconnection.*;
import com.exam.validator.*;

public class QuotaBasedSeatUpdation {
	
	
	public void quota() throws SQLException {
	
		 boolean page = true;
		 System.out.println();
	   	   System.out.println("\t"+"\t"+"\t"+"***********************************************************");
	 	   while(page) {
	 	   System.out.println("");
	 	   System.out.println("\t"+"\t"+"\t"+"\t"+"  ** AVAILABLE QUOTA AND SEATS ** :");
	 	   System.out.println("");
	 	   
	 	   
	 	   
	 	   Connection connection=DBConnection.getInstance().getConnection();
	 	   Statement statement=connection.createStatement();
	 	   
	 	   System.out.println("select qt.quota,qs.seats FROM quota_seats as qs\n"
	 	   		+ "inner join quota_table as qt on qt.quota_id = qs.quota_id;");
	 	   
	 	   ResultSet resultSet=statement.executeQuery("select qt.quota,qs.seats FROM quota_seats as qs\n"
	 	   		+ "inner join quota_table as qt on qt.quota_id = qs.quota_id;");
	 	   
	 	   while(resultSet.next()) {
	 		  System.out.println("\t"+"\t"+"\t"+"***********************************************************");
	 		  System.out.println();
	  		  System.out.println("\t"+"\t"+"\t"+"\t"+resultSet.getString("quota")+"  :  "+resultSet.getString("seats")); 
	  		  System.out.println("");
	  		  System.out.println("\t"+"\t"+"\t"+"***********************************************************");
	 		   
	 	   }
	 	   resultSet.close();
	 	   statement.close();
	 	   connection.close();
	 	   
	 	   
	 	    System.out.println();
	   		System.out.println("\t"+"\t"+"\t"+"\t"+"  **  QUOTA MENU **");
	   		System.out.println();
	   		System.out.println("\t"+"\t"+"\t"+"Enter 1 to Update Quota");
	   		System.out.println("\t"+"\t"+"\t"+"Enter 2 to Exit");
	   		System.out.println();
	   		System.out.println("Enter Your choice :");
	   		
	   	
			byte choice=NumberBasedValidator.choiceChecker();
			switch(choice) {
		   		case 1:
		   			this.update();//
		   			break;
		   		case 2:
		   			page = false;
		   			break;
		   		default:
		   			System.out.println("\t"+"\t"+"\t"+"\t"+" !!! INVALID INPUT !!!");
					System.out.println();
		   		    break;
		     }
	   	 }
	}
	
		private  void update() throws SQLException{
			   int i = 1;
			  
			   while(i<6) { 
			      if(i == 1) {
			    	  seats(1);
			    	  i++;
			    }
			      if(i == 2) {
			    	  seats(2);
			    	  i++;
			    }  
			      if(i == 3) {
			    	  seats(3);
			    	  i++;
			    }
			      if(i == 4) {
			    	  seats(4);
			    	  i++;
			    }
			      if(i == 5) {
			    	  i++;
			    	  System.out.println("\t"+"\t"+"\t"+"\t"+"  ** QUOTA UPDATED SUCESSFULLY ** ");
			    	  System.out.println("");
			 		  System.out.println("\t"+"\t"+"\t"+"***********************************************************");
			      }
			   }
			
		}
		public void seats(int i) throws SQLException { // string function is modified into int function
			
			Connection connection =DBConnection.getInstance().getConnection();
			Statement statement=connection.createStatement();
			
			 byte seats = 0;
			 Scanner sc = new Scanner(System.in);
			 System.out.println("\t"+"Enter the seats in % to be in " + (i == 1 ?"OC" : i == 2 ? "BC" : i == 3 ? "SC" : "ST" )+ " Quota: ");
	   	     seats = sc.nextByte();
	   	     if(seats >= 0 && seats%10 == 0) {
	   	    	 
	   	    	 System.out.println("update quota_seats"
	   	    	 		+ "set seats="+(seats/10)
	   	    	 		+ "where quota_id="+i+";");
	   	    	statement.executeUpdate("update quota_seats\n"
	   	    			+ "set seats="+(seats/10)+"\n"
	   	    			+ "where quota_id="+i+";");
	   	   	     
	   	     }else {
	   	      System.out.println("\t"+"\t"+"\t"+"\t"+"!!! ENTER A VAILD NUMBER !!! "); 
	   	      seats(i);
	   	      }
	   	     statement.close();
	   	     connection.close();
	   	     
	   	     
	        } 
	
	}

