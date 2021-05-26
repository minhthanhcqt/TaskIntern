package com.hahalolo.api.and.mongodb.service;

import java.util.Map;

import org.bson.Document;

public interface UserService {

	Document findById(String id);
	 Map<String, String>  createUser(Document document);
	 Map<String, String>  verifyUser(String id, String otp);
	 Map<String, String> sendcodeOTP(String id);
	 Map<String, Boolean> userLogin(String name, String password);
}
