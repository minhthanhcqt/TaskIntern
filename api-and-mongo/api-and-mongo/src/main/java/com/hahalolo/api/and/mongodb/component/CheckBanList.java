package com.hahalolo.api.and.mongodb.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CheckBanList {
	public Boolean checkBanList(String mail){
		List<String > banlist=new ArrayList();
		banlist.add("com.net");
		banlist.add("pro");
		String []a=mail.split("@");
		String domain=a[a.length-1];
		if(banlist.contains(domain)) {
			return false;
		}
		else
			return true;
	}

}
