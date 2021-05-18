package com.hahalolo.user.userservice;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.hahalolo.user.userentity.UserEntity;
import com.hahalolo.user.userrepositories.UserConnectDB;
import com.hahalolo.user.userrepositories.UserEnterInformation;
import com.hahalolo.user.userrepositories.UserQuery;
import com.hahalolo.user.userrepositories.UserRepositories;

public class UserWriteDB {
	
	public static final void  WriteData( UserEntity a)
    {
    	try {
            Connection conn = UserConnectDB.getConnection();
            Statement stmt = conn.createStatement();
		            String query=UserQuery.QueryInsert(a);
		            stmt.executeUpdate(query);
            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
        }
    	
    }
    

}
