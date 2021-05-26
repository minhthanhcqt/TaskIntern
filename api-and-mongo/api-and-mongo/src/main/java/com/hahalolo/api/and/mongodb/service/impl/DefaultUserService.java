package com.hahalolo.api.and.mongodb.service.impl;

import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hahalolo.api.and.mongodb.repository.UserRepository;
import com.hahalolo.api.and.mongodb.service.UserService;
import com.mongodb.client.model.Filters;

@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Document findById(String id) {
		if (id != null && ObjectId.isValid(id)) {
			Bson filter = Filters.eq(new ObjectId(id));
			return userRepository.findOne(filter);
		}
		return null;
	}

	@Override
	public Map<String, String> createUser(Document document) {
		return userRepository.createUser(document);
	}

	@Override
	public Map<String, String> verifyUser(String id, String otp) {
		return userRepository.verifyAccount(id, otp);
	}

	

	@Override
	public Map<String, String> sendcodeOTP(String id) {
		return userRepository.sendCodeOTP(id);
	}

	@Override
	public Map<String, Boolean> userLogin(String name, String password) {
		return userRepository.userLogin(name, password);
	}

}
