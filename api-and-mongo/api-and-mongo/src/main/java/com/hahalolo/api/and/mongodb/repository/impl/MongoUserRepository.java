package com.hahalolo.api.and.mongodb.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hahalolo.api.and.mongodb.component.CheckBanList;
import com.hahalolo.api.and.mongodb.component.CheckDefineMail;
import com.hahalolo.api.and.mongodb.component.CheckPhoneNumber;
import com.hahalolo.api.and.mongodb.component.CheckUserNameDuplicate;
import com.hahalolo.api.and.mongodb.component.GetOTPCode;
import com.hahalolo.api.and.mongodb.repository.UserRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Repository
public class MongoUserRepository implements UserRepository {
	private static final String COLLECTION_USER = "user";
	private static final String ID_USER = "_id";
	private static final String CODE_COUNTRY = "codecountry";
	private static final String USER_NAME = "username";
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoUserRepository.class);
	@Autowired
	private MongoDatabase mongoDatabase;
	@Autowired
	public CheckBanList checkBanList;
	@Autowired
	public CheckDefineMail checkDefineMail;
	@Autowired
	public CheckUserNameDuplicate checkUserNameDuplicate;
	@Autowired
	public GetOTPCode getOTPCode;

	@Autowired
	public CheckPhoneNumber checkPhone;

	@Override
	public Document findOne(Bson filter) {
		MongoCollection<Document> userCollection = mongoDatabase.getCollection(COLLECTION_USER);
		return userCollection.find(filter).first();
	}

	@Override
	public Map<String, String> createUser(Document document) {
		Map<String, String> a = new HashMap<String, String>();
		String userName = document.getString("username");
		String passWord = document.getString("password");
		String passWordHashed=BCrypt.hashpw(passWord, BCrypt.gensalt(12));
		document.replace("password", passWordHashed);
		LOGGER.debug(passWordHashed);
		MongoCollection<Document> collection = mongoDatabase.getCollection(COLLECTION_USER);
		if (checkDefineMail.defineMail(userName)) {
			if (checkBanList.checkBanList(userName) && checkUserNameDuplicate.userNameDuplicate(userName)) {
				collection.insertOne(document);
				a.put("_id", String.valueOf((ObjectId) document.get("_id")));
			} else {
				a.put("Message", "Mail is not Valid");
			}
		} else {
			String countryCode = document.getString(CODE_COUNTRY);
			if (countryCode == null) {
				a.put("Message", "CountryCode is null");
			} else {
				if (checkUserNameDuplicate.userNameDuplicate(userName)) {

					if (checkPhone.checkIsValidNumber(countryCode, userName)) {
						collection.insertOne(document);
						a.put("_id", String.valueOf((ObjectId) document.get("_id")));
					} else
						a.put("Message", "Phone number does not belong to the above country");
				} else {
					a.put("Message", "User name is exist");
				}

			}

		}
		return a;
	}

	@Override
	public Map<String, String> verifyAccount(String id, String otp) {
		MongoCollection<Document> userCollection = mongoDatabase.getCollection(COLLECTION_USER);
		Bson filter = Filters.eq(new ObjectId(id));
		Document document = userCollection.find(filter).first();
		String otpCode = document.getString("otp");
		Map<String, String> map1 = new HashMap<String, String>();
		if (otpCode.equals(otp)) {
			userCollection.updateOne(Filters.eq(new ObjectId(id)),
					new Document("$set", new Document("verified", true)));
			map1.put("message", "Success");
			return map1;
		} else {
			userCollection.updateOne(Filters.eq(new ObjectId(id)),
					new Document("$set", new Document("verified", false)));
			map1.put("message", "faild");
			return map1;
		}

	}

	@Override
	public Map<String, String> sendCodeOTP(String id) {
		Map<String, String> map = new HashMap<String, String>();
		MongoCollection<Document> userCollection = mongoDatabase.getCollection(COLLECTION_USER);
		Bson filter = Filters.eq(new ObjectId(id));
		String otpcode = getOTPCode.newCodeOTP();
		userCollection.findOneAndUpdate(filter, new Document("$set", new Document("otp", otpcode)));
		Document document = userCollection.find(filter).first();
		String userName = document.getString(USER_NAME);
		if (checkDefineMail.defineMail(userName)) {
			// sendMail OTP;
		} else {
			// sendMessage;
		}
		map.put("Success", otpcode);
		return map;
	}

	@Override
	public Map<String, Boolean> userLogin(String userName, String passWord) {

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		MongoCollection<Document> userCollection = mongoDatabase.getCollection(COLLECTION_USER);
		Bson filter = Filters.eq(USER_NAME, userName);
		Document document = userCollection.find(filter).first();
		String passWordHash = document.getString("password");
		if (BCrypt.checkpw(passWord, passWordHash)) {
			map.put("Login", true);
		} else {
			map.put("Login", false);
		}
		return map;

	}

}
