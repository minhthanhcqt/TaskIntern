package com.hahalolo.api.and.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class BeansResource {
	public static final String COLLECTION_USER = "user";
	
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}

	@Bean
	public MongoDatabase mongoDatabase(MongoClient mongoClient) {
		return mongoClient.getDatabase("db-user");
	}

	
}
