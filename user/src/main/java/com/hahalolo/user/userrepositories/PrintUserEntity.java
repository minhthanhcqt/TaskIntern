package com.hahalolo.user.userrepositories;

import com.hahalolo.user.userentity.UserEntity;

public class PrintUserEntity {
	public static final void printUser(UserEntity userEntity)
    {
    	System.out.print("UserNane: "+ userEntity.getUserName()+"\t");
    	System.out.print("PassWord: "+ userEntity.getPassword()+"\t");
    	System.out.print("FullName: "+ userEntity.getFullName()+"\t");
    	System.out.print("BirthDay: "+ userEntity.getBirthDay()+"\t");
    	System.out.println("Gender: "+ userEntity.getGender());
    	
    	
    }

}
