package com.servlet.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {
	
	private static DBConnection instance = null;
	private final String url = "jdbc:postgresql://localhost/Onilne_Examination_db";
	private final String user = "postgres";
	private final String password = "Kanna872717##";
	Connection connection = null;

	private DBConnection() {

	}

	private void dbConnector() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public Connection getConnection() throws SQLException{
		this.dbConnector();
		return connection;
	}
	
	public static DBConnection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else if (instance.connection.isClosed()) {
			instance = new DBConnection();
		}
		return instance;
	}

}
