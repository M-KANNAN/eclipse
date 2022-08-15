package com.ithelpdesk.dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static DBConnection instance = null;
	private final String url = "jdbc:postgresql://localhost/ITHelpDesk";
	private final String user = "postgres";
	private final String password = "Kanna872717##";
	Connection connection = null;

	private DBConnection() {

	}

	private void dbConnector() throws SQLException, ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, user, password);
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		this.dbConnector();
		return connection;
	}

	public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.getConnection().isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}

}
