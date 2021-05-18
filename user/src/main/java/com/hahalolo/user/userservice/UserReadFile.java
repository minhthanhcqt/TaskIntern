package com.hahalolo.user.userservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.hahalolo.user.userentity.UserEntity;

public class UserReadFile {
	
	 public static final void readFile(List<UserEntity>userList)
	    {
	        try{
	            File f=new File("text.txt");
	            FileReader fr = new FileReader(f);
	            BufferedReader br = new BufferedReader(fr);
	            String line;
	      
	            while((line=br.readLine())!=null)
	            {
	            
	            	String[]x=line.split("/");
	            	userList.add(new UserEntity(x[0], x[1], x[2], x[3], x[4], x[5],x[6]));
	            	
	            }
	            
	            fr.close();
	            br.close();
	            System.out.println("Data Successfully reading into object");
	        }
	        catch (IOException e){
	            System.out.println("I/O Error: " + e);
	        }
	      
	    }

}
