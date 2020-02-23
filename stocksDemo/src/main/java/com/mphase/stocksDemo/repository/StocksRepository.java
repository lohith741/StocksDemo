package com.mphase.stocksDemo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.mphase.stocksDemo.model.Stocks;

public interface StocksRepository extends MongoRepository<Stocks, String>{
	
}
