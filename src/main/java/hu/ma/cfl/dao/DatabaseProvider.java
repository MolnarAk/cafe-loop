package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProvider {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static final DatabaseProvider instance = new DatabaseProvider(
		"jdbc:mysql://localhost:3306/cafe_loop2",
		"root",
		"admin"
	);
	
	public static DatabaseProvider getInstance() {
		return instance;
	}
	
	private final String url;
	private final String username;
	private final String password;
	
	private DatabaseProvider(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}