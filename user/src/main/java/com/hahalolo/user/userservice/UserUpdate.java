package com.hahalolo.user.userservice;

import java.sql.Connection;
import java.sql.Statement;

import com.hahalolo.user.userrepositories.UserConnectDB;

public class UserUpdate {
	
	 public void EditInformation(String id, String fullname)
	    {
	    	 try {  
//	    		 
	    		 
	    		 Connection conn = UserConnectDB.getConnection();
	    	        Statement stmt = conn.createStatement();
	    	       String sql= "UPDATE user SET fullName='"+fullname+"' WHERE idUser ="+id;
	    	        stmt.executeUpdate(sql); 
	    	    } catch(Exception e) {
	    	        System.out.println(e);
	    	    }
	    	
	    }

}
