package com.hahalolo.user.userrepositories;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserConnectDB {
	 public static Connection getConnection() {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(UserRepositories.DB_URL, UserRepositories.USER_NAME, UserRepositories.PASSWORD);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn;
	    }

}
