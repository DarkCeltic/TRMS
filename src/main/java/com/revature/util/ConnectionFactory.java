package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String username;
	private String password;
	private String url;
	private static ConnectionFactory connectionFactory;
	private static final String SCHEMA = "public";

	public static Connection getConnection() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory.createConnection();
	}
	
	private ConnectionFactory() {
		username = System.getenv("POSTGRES_USERNAME");
		password = System.getenv("POSTGRES_PASSWORD");
		url = "jdbc:postgresql://" + System.getenv("POSTGRES_URL") + ":5432/TRMS?";
	}
	
	private Connection createConnection() {
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setSchema(SCHEMA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
