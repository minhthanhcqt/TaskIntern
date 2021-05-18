package com.hahalolo.user.userservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.hahalolo.user.userrepositories.UserConnectDB;

public class UserDelete {
	 public  void Delete(String id)
	    {
	    	 try {  
	    	        Connection connection = UserConnectDB.getConnection();
	    	        PreparedStatement st = connection.prepareStatement("DELETE FROM user WHERE idUser = ?");
	    	        st.setString(1,id );
	    	        st.executeUpdate(); 
	    	    }catch(Exception e) {
	    	        System.out.println(e);
	    	    }
	    	
	    }

}
