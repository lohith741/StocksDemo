package com.mphase.stocksDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration{
//    @Autowired
//    private Environment env;
//
//    @SuppressWarnings("deprecation")
//	@Bean
//    public MongoDbFactory mongoDbFactory() {
//        return new SimpleMongoDbFactory(new MongoClientURI(env.getProperty("spring.data.mongodb.uri")));
//    }
//
//	@Bean
//	public MongoTemplate mongoTemplate() {
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//
//		return mongoTemplate;
//
//    }

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		return new MongoClient("localhost", 27017);
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "stocks_db";
	}
}
