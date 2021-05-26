package com.hahalolo.api.and.mongodb.component;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Component
public class CheckUserNameDuplicate {

	@Autowired
	private MongoDatabase mongoDatabase;

	public static final String COLLECTION_USER = "user";
	public static final String USER_NAME="username";

	public Boolean userNameDuplicate(String mail) {
		Bson filter = Filters.eq(USER_NAME, mail);
		MongoCollection<Document> userCollection = mongoDatabase.getCollection(COLLECTION_USER);
		if (userCollection.find(filter).first() == null) {
			return true;
		} 
			return false;
	}

}
