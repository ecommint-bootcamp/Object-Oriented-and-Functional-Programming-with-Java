package org.javaturk.jpa.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private static Properties settings = new Properties();
	private static String fileName = "jdbc.properties";

	private static String url;
	private static String ip;
	private static String port;
	private static String username;
	private static String password;
	private static String driver;

	static {
		FileReader in = null;
		try {
			in = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			System.out.println("File is not found: " + fileName);
			e1.printStackTrace();
		}
		try {
			settings.load(in);
		} catch (IOException e) {
			System.out.println("Problem with IO: " + e.getMessage());
			e.printStackTrace();
		}

		// settings.list(System.out);

		url = settings.getProperty("url");
		username = settings.getProperty("username");
		password = settings.getProperty("password");
		driver = settings.getProperty("driver");
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println(driver + " is not found: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out
					.println("In JDBCUtil, problem with getting a connection: "
							+ e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}
}
