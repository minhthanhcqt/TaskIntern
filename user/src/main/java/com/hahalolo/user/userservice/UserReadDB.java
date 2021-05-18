package com.hahalolo.user.userservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hahalolo.user.userentity.UserEntity;
import com.hahalolo.user.userrepositories.SetGender;
import com.hahalolo.user.userrepositories.UserConnectDB;

public class UserReadDB {
	
	public static final void ReadDatabase(List<UserEntity>userList)
    {
    	try(Connection conn = UserConnectDB.getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery("select * from user");
    	      ) {		      
    	         while(rs.next()){
    	        	String username_db=rs.getString("userName");
    	        	String password_db=rs.getString("password");
    	        	String firstName_db=rs.getString("firstName");
    	        	String lastName_db=rs.getString("lastName");
    	        	String middleName_db=rs.getString("middleName");
    	        	String  date_db=rs.getString("birthDay");
    	        	String gender_db=rs.getString("gender");
    	        	gender_db=SetGender.setGenderFromDB(String.valueOf(gender_db));
    	        	UserEntity a=new UserEntity(username_db, password_db, firstName_db,lastName_db, middleName_db,date_db,gender_db);
    	        	userList.add(a);
    	         }
    	         conn.close();
    	      } catch (SQLException e) {
    	         e.printStackTrace();
    	      } 
    	   }

}
