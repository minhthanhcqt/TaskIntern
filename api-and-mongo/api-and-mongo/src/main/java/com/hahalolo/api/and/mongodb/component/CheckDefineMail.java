package com.hahalolo.api.and.mongodb.component;

import org.springframework.stereotype.Component;

@Component
public class CheckDefineMail {
	public Boolean defineMail(String mail) {
		if (mail != null && mail.contains("@")) {
			return true;
		}
		return false;
	}

}
