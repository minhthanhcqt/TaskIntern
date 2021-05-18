package com.hahalolo.user.userservice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.hahalolo.user.userentity.UserEntity;

public class UserWriteFile {
	public static final void  writeFile(UserEntity userEntity)
	    {
	        try (FileWriter f = new FileWriter("text.txt", true);
	        BufferedWriter b = new BufferedWriter(f);
	        PrintWriter p = new PrintWriter(b);)
	        {
	            p.print(userEntity.getUserName()+"/");
	            p.print(userEntity.getPassword()+"/");
	            p.print(userEntity.getFirstName()+"/");
	            p.print(userEntity.getLastName()+"/");
	            p.print(userEntity.getMiddleName()+"/");
	            p.print(userEntity.getBirthDay()+"/");
	            p.println(userEntity.getGender());
	            p.flush();
	           
	        }
	        catch (IOException i)
	        {
	            i.printStackTrace();
	        }
	    }

}
