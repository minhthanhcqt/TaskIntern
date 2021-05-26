package com.hahalolo.api.and.mongodb.repository;

import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;


public interface UserRepository {

	Document findOne(Bson filter);
	Map<String, String> createUser(Document document );
	Map<String, String> verifyAccount(String id, String codeOTP);
	Map<String, String> sendCodeOTP(String id);
	Map<String, Boolean> userLogin(String userName, String password);
}
