package dev.recommend.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() {
		Properties prop = new Properties();
		
		try {
			FileInputStream fs = new FileInputStream("src/main/java/resources/jdbc.properties");
		
			prop.load(fs);
			
			final String DB_URL = prop.getProperty("url");
			final String DATABASE_NAME = prop.getProperty("database");
			final String USER = prop.getProperty("username");
			final String PASSWORD = prop.getProperty("password");
			
			return DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return null; 
		
	}
}
