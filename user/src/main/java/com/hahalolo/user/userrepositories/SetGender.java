package com.hahalolo.user.userrepositories;

public class SetGender {
	public static final String setGenderFromDB(String gender)
	{
		if (gender.equals("1"))
		{
			return "Nam";
		}
		else
		{
			return "Nu";
		}
	}
	
	public static final String setGenderFromUser(String gender)
	{
		if (gender.equals("Nam"))
		{
			return "1";
		}
		else
		{
			return "0";
		}
	}

}
