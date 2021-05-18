package com.hahalolo.user.userrepositories;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	public static final String GetCurrentDate()
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 return sdf.format(new Date());
	}

}
