package com.hahalolo.user.userrepositories;

import com.hahalolo.user.userentity.UserEntity;

public class UserQuery {
	
	public static final String QueryInsert(UserEntity userEntity)
	{
		return "INSERT INTO user(userName, password, firstName, lastName, middleName, fullName, birthDay,gender, createdAt, createdBy, updateAt, updateBy, role) VALUES('"+userEntity.getUserName()+"','"+userEntity.getPassword()+"','"+userEntity.getFirstName()+"','"+userEntity.getLastName()+"','"+userEntity.getMiddleName()+"','"+userEntity.getFullName()+"','"+userEntity.getBirthDay()+"',"+SetGender.setGenderFromUser(userEntity.getGender())+",'"+FormatDate.GetCurrentDate()+"','Admin','"+FormatDate.GetCurrentDate()+"','Admin',1)";
	}

}
