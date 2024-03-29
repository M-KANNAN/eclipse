package com.helpdesk.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.helpdesk.dbconnection.DBConnection;

public class AdminLogin {

	public void adminLogin() {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a user name ");
		String name = scanner.next();
		System.out.println("Enter a user pass word");
		String pasword = scanner.next();

		try {

			Connection connection = DBConnection.getInstance().getConnection();
			
			String adminLoginQuery="select user_id from user_details\n" + "where user_name= ? and user_pass= ? and is_admin;";
			
			
			PreparedStatement preparedStatement=connection.prepareStatement(adminLoginQuery);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pasword);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				if (resultSet.getInt("user_id") != 0) {
					System.out.println();
					System.out.println("!!! Login Sucessfull !!!");
					System.out.println();
					int userId = resultSet.getInt("user_id");
					this.adminLoginMenu(userId);
				} else {
					System.out.println();
					System.out.println("!!! Invalid login !!!");
					System.out.println();
				}
			} else {
				System.out.println();
				System.out.println("!!! Invalid login !!!");
				System.out.println();
			}
			
	
			
			resultSet.close();
			preparedStatement.close();
			connection.close();
		
			

		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}

	private void adminLoginMenu(int userId) throws SQLException {
		
		
		Scanner scanner = new Scanner(System.in);

		boolean isExit = true;

		while (isExit) {

			System.out.println("Enter 1 to create support request");
			System.out.println("Enter 2 t view my request");
			System.out.println("Enter 3 to update a ticket");
			System.out.println("Enter 4 to view input fields for a ticket");
			System.out.println("Enter 5 to pick a request");
			System.out.println("Enter 6 to see my picked request");
			System.out.println("Enter 7 to delete ");
			System.out.println("Enter 8 to exit");

			switch (scanner.nextByte()) {

			case 1:
				new SupportRequest().adminSupportRequest(userId);
				break;

			case 2:
				viewSupportRequest(userId);
				break;

			case 3:
				updateSupportRequest(userId);
				break;
				
			case 5 : 
				pickRequest(userId);
				break;

			case 4:
				inputFeildViewer(userId);
				break;
				
			case 6:
				myRequest(userId);
				break;

			case 8:
				isExit = false;
				break;

			default:
				System.out.println("!!! Invalid choice !!!");
				break;

			}

		}
		
	}

	private void inputFeildViewer(int userId) throws SQLException {
		
		Connection connection = DBConnection.getInstance().getConnection();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(
				"select tickect_id,subject,discription,admin_id,time_creation,status_Id from ticket_details\n"
						+ "where user_id=" + userId + ";");

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			System.out.println("Admin Id" + resultSet.getInt("admin_id"));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
//			System.out.println("Status : " + this.statusChecker(resultSet.getInt("status")) );
			System.out.println("         **   ");
			System.out.println();
		}

		resultSet.close();
		statement.close();
		connection.close();
	}

	private void myRequest(int userId) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);

		Connection connection = DBConnection.getInstance().getConnection();

		Statement statement = connection.createStatement();
			
		String ticketQuery="select td.tickect_id,td.subject,td.discription,td.time_creation,td.status_Id,ud.user_name as admin_name,ud1.user_name as user_name\n"
				+ "from ticket_details as td\n"
				+ "right join user_details as ud on ud.user_id = td.admin_id\n"
				+ "right join user_details as ud1 on ud1.user_id = td.user_id\n"
				+ "where td.admin_id= ?;";  // shows only one because of null
		
		PreparedStatement preparedStatement=connection.prepareStatement(ticketQuery);
		
	
		preparedStatement.setInt(1, userId);
		 ResultSet resultSet=preparedStatement.executeQuery();

		ArrayList<Integer> out = new ArrayList<Integer>();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			out.add(resultSet.getInt("tickect_id"));
			if (resultSet.getString("admin_name") == null) {
				System.out.println("Admin Not Assigned");
			} else {

				System.out.println("Assigned to : " + resultSet.getString("admin_name"));
			}
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			System.out.println("Admin Id" + resultSet.getInt("admin_id"));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + this.statusChecker(resultSet.getInt("status")) );
			System.out.println("         **   ");
			System.out.println();
		}
		
		boolean isExit=true;
		
		while(isExit) {
			System.out.println();
			System.out.println("Enter 1 to chat for a  ticket");
			System.out.println("Enter 2 to exit");
			System.out.println();
			
			switch(scanner.nextByte()) {
			
			case 1 :
				int tickectNumber=0;
				System.out.println("Enter a tickect number");
				tickectNumber=0;
				while(true) {
					if(out.contains(tickectNumber)) {
						this.viewUserChat(tickectNumber);
						break;
					}
					else {
						System.out.println("Invalid ticket number");
					}
				}
				break;

			case 2 :
				isExit=false;
				break;
			}
			
			
		}
	

		resultSet.close();
		statement.close();
		connection.close();
		
		System.out.println();
		System.out.println();
		
		
	}

	private void replayForUser(int tickectNumber, int senderId, int reciverID) throws SQLException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a messge you want to chat with user");

		String message = scanner.nextLine();

		Connection connection = DBConnection.getInstance().getConnection();

		String chatForAdmin = "insert into chat_details(ticket_id,sender_id,reciver_id,isadmin,chat_message)\n"
				+ "values\n" + "(?,?,?,?,?);"; //

		PreparedStatement preparedStatement = connection.prepareStatement(chatForAdmin);

		preparedStatement.setInt(1, tickectNumber);
		preparedStatement.setInt(2, senderId);
		preparedStatement.setInt(3, reciverID);
		preparedStatement.setBoolean(4, false);
		preparedStatement.setString(5, message);

		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
		
		
		
	}

	private void viewUserChat(int tickectNumber) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		
		Connection connection = DBConnection.getInstance().getConnection();

		String adminAssignedCheck = "select admin_id,user_id from ticket_details \n" + "where tickect_id= ? ;";

		PreparedStatement preparedStatement = connection.prepareStatement(adminAssignedCheck);
		preparedStatement.setInt(1, tickectNumber);

		ResultSet resultSet1 = preparedStatement.executeQuery();
		if (resultSet1.next() && resultSet1.getInt("admin_id") != 0) { // admin is assiged or not

			String chatQuerry = "SELECT ud.user_name,cd.chat_message FROM chat_details AS cd\n"
					+ "INNER join  user_details as ud on ud.user_id = cd.sender_id\n"
					+ "WHERE cd.ticket_id= ? ;";

			preparedStatement = connection.prepareStatement(chatQuerry);

			preparedStatement.setInt(1, tickectNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println("Sender : "+resultSet.getString("user_name")+" Message : " + resultSet.getString("chat_message"));
			}
			
		
			while(true) {
				System.out.println();
				System.out.println("Enter 1 to chat");
				System.out.println();
				byte choice=scanner.nextByte();
				if(choice == 1) {

					this.replayForUser(tickectNumber, resultSet1.getInt("user_id"), resultSet1.getInt("admin_id"));
					break;
				}
				else {
					System.out.println("!!! Redirecting to UserLogin !!!");
					break;
				}
				
			}
			

			resultSet.close();
			preparedStatement.close();
			resultSet1.close();
			connection.close();
			

		} else {
			System.out.println();
			System.out.println("!!! Admin is not assigned to chat !!!");
			System.out.println();
		}
		
		
	}

	private void pickRequest(int userId) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a tickect number to be updated ");

		Connection connection = DBConnection.getInstance().getConnection();

		Statement statement = connection.createStatement();
		
		System.out.println();
		System.out.println("All request");
		System.out.println();
		ResultSet resultSet = statement
				.executeQuery("select * from ticket_details;");

		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		
		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			arrayList.add(resultSet.getInt("tickect_id"));

			if(resultSet.getInt("admin_id") == 0) {
				System.out.println(" Admin Not Assigned");
			}
			else {

				System.out.println("Assigned to " + resultSet.getInt("admin_id") );
			}
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + this.statusChecker(resultSet.getInt("status_Id")) );
			System.out.println("         **   ");
			System.out.println();
		}
		
		int pickId=0;

		while(true) {
			System.out.println("Enter a request Id to be picked ");
			pickId=scanner.nextInt();
			if(arrayList.contains(pickId)) {
				//this.replayForUser(pickId);
				break;
			}
			else {
				System.out.println("Enter a valid ticked number");
			}
		}
		
		
	
		
		statement.close();
		resultSet.close();
		
		Statement statement2=connection.createStatement();
		statement2.executeUpdate("update ticket_details\n"
				+ "set admin_id="+pickId+"\n"
				+ "where tickect_id=1;\n"
				+ "");
		
		statement2.executeUpdate("update ticket_details\n"
				+ "set status_id = 2\n"
				+ "where tickect_id =2;");
		
		System.out.println();
		
		System.out.println("!!! Picked !!!");
		System.out.println();
		statement2.close();
		connection.close();
		
		
		
	}

	private void updateSupportRequest(int userId) throws SQLException {
		
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a tickect number to be updated ");

		Connection connection = DBConnection.getInstance().getConnection();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select  tickect_id from ticket_details\n" + "where user_id=" + userId + ";");

		while (resultSet.next()) {
			System.out.println(resultSet.getInt("tickect_id") + "\t");
		}
		

		int tickectId = scanner.nextInt();

		resultSet.close();

		System.out.println("Enter a number form the given ticket id");

		ResultSet resultSet2 = statement.executeQuery(
				"select user_id,subject,discription from ticket_details\n" + "where tickect_id=" + tickectId + ";");

		if (resultSet2.next()) {

			if (resultSet2.getInt("user_id") == userId) {
				Statement preparedStatement = connection.createStatement();

				System.out.println("Enter a subject");
				scanner.nextLine();
				String subject = scanner.nextLine();

				System.out.println("Enter a discription");
				String discription = scanner.nextLine();
				
				

				Statement statement1=connection.createStatement();
				
				ResultSet resultSet3=statement1.executeQuery("select user_id,user_name from user_details where is_admin;");
				
				System.out.println("!!! Available Admin !!!");
				
				ArrayList<Integer> arrayList=new ArrayList<Integer>();
				
				while(resultSet3.next()) {
					
					System.out.print("Admin ID : "+resultSet3.getInt("user_id") +"\t");
					System.out.print("Admin name : "+resultSet3.getString("user_name"));
					arrayList.add(resultSet3.getInt("user_id"));
					System.out.println();
				}
				
				
				
				resultSet3.close();
				statement1.close();
				
				int adminId=0;
				while(true) {
					System.out.println("Enter a Admin Id");
					adminId=scanner.nextInt();
					
					if(arrayList.contains(adminId)) {
						break;
					}
					else {
						System.out.println("Invalid admin");
					}
				}
				
	

				preparedStatement.executeUpdate("update ticket_details\n" + "set subject='" + subject + "'\n"
						+ "where tickect_id=" + tickectId + ";");

				preparedStatement.executeUpdate("update ticket_details\n" + "set discription='" + discription + "'\n"
						+ "where tickect_id=" + tickectId + ";");
				
				preparedStatement.executeUpdate("update ticket_details\n" + "set admin_id=" + adminId + "\n"
						+ "where tickect_id=" + tickectId + ";");

				preparedStatement.close();
			} else {
				System.out.println("!!! invalid user id !!!");
				System.out.println("!!! Redirect to admin meue !!!");
			}

		} else {
			System.out.println("!!! INVALID TICKECT ID !!!");
			System.out.println("!!! Redirect to admin meue !!!");
		}
		statement.close();
		connection.close();
		
		System.out.println("Details updated");
		
	}

	private void viewSupportRequest(int userId) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);

		Connection connection = DBConnection.getInstance().getConnection();

		Statement statement = connection.createStatement();
			
		String ticketQuery="select * from ticket_details where user_id= ?;";  // shows only one because of null
		
		PreparedStatement preparedStatement=connection.prepareStatement(ticketQuery);
		
	
		preparedStatement.setInt(1, userId);
		 ResultSet resultSet=preparedStatement.executeQuery();

		ArrayList<Integer> out = new ArrayList<Integer>();

		while (resultSet.next()) {
			System.out.println();
			System.out.println("Resuest Id : " + resultSet.getInt("tickect_id"));
			out.add(resultSet.getInt("tickect_id"));
			if (resultSet.getInt("admin_id") == 0) {
				System.out.println("Admin Not Assigned");
			} else {

				System.out.println("Assigned to : " + getUserName(resultSet.getInt("admin_id")));
			}
			System.out.println("requested by : " + getUserName(resultSet.getInt("user_Id")));
			System.out.println("Subject : " + resultSet.getString("subject"));
			System.out.println("Discription : " + resultSet.getString("discription"));
			System.out.println("Time of creation : " + resultSet.getTimestamp("time_creation"));
			System.out.println("Status : " + this.statusChecker(resultSet.getInt("status_Id")));
			System.out.println("         **   ");
			System.out.println();
		}

		boolean isExit = true;

		while (isExit) {
			System.out.println();
			System.out.println("Enter 1 to chat for a  ticket");
			System.out.println("Enter 2 to exit");
			System.out.println();

			switch (scanner.nextByte()) {

			case 1:
				int tickectNumber = 0;

				tickectNumber = 0;
				while (true) {
					System.out.println("Enter a tickect number");
					tickectNumber = scanner.nextInt();
					if (out.contains(tickectNumber)) {
						this.viewUserChat(tickectNumber);
						break;
					} else {
						System.out.println();
						System.out.println("Invalid ticket number");
						System.out.println();
					}
				}
				break;

			case 2:
				isExit = false;
				break;
			}

		}

		resultSet.close();
		statement.close();
		connection.close();
	}

	private String statusChecker(int i) {
		
		if(i == 1) {
			return "open";
		}
		else if (i == 2) {
			return "onprogress";
		}
		else if(i == 3) {
			return "closed";
		}
		else if (i == 4) {
			return "archived";
		}
		else {
			return "deleted";
		}
		
	}
	
	private String getUserName(int userId) throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		
		String userNameGetter="select user_name from user_details\n"
				+ "where user_id= ?;";
		
		PreparedStatement preparedStatement=connection.prepareStatement(userNameGetter);
		preparedStatement.setInt(1, userId);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return resultSet.getString("user_name");
		}
		else {
			return null;
		}
		
	}

}
