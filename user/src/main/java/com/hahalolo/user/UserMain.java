package com.hahalolo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hahalolo.user.userentity.UserEntity;
import com.hahalolo.user.userrepositories.PrintUserEntity;
import com.hahalolo.user.userrepositories.UserEnterInformation;
import com.hahalolo.user.userservice.UserDelete;
import com.hahalolo.user.userservice.UserReadDB;
import com.hahalolo.user.userservice.UserReadFile;
import com.hahalolo.user.userservice.UserUpdate;
import com.hahalolo.user.userservice.UserWriteDB;
import com.hahalolo.user.userservice.UserWriteFile;


public class UserMain {
	private static List<UserEntity>userList;
	
	public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	System.out.print("Choose: \n 1.Enter new User: \t 2.Display List User From File Text: \t 3.Display list user from Database: \t 4.Delete User:\t 5.Edit Information \n");
	String c=scanner.nextLine();
	userList=new ArrayList<>();
	if(c.equals("1"))
	{
		UserEntity userEntity=new UserEntity();
		UserEnterInformation.EnterInformation(userEntity);
		UserWriteFile.writeFile(userEntity);
		UserWriteDB.WriteData(userEntity);
	}
	else
	{
        if(c.equals("2"))
        {
        	  UserReadFile.readFile(userList);
        
	        for(int i=0; i<userList.size() ;i++)
	        {
	           
	           
	           PrintUserEntity.printUser(userList.get(i));
	
	        }
        }
        else
        {
        	
        	if(c.equals("3"))
            {
            	 UserReadDB.ReadDatabase(userList);
    	        for(int i=0; i<userList.size() ;i++)
    	        {
    	           
    	        	PrintUserEntity.printUser(userList.get(i));
    	           
    	
    	        }
            }
        	else
        	{
        		if(c.equals("4"))
	            {
        			UserDelete userDelete=new UserDelete();
        			userDelete.Delete("1");
	    	       
	            }
        		else
        		{
        			
        			if(c.equals("5"))
    	            {
            			UserUpdate userUpdate=new UserUpdate();
            			userUpdate.EditInformation("2", "HahaLOLO");
    	    	       
    	            }
        			
        		}
        	}
        	
        }   
   
	}

}
}
