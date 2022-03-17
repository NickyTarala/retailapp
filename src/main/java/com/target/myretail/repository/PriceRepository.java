package com.target.myretail.repository;

import com.target.myretail.model.mongodb.pricecluster.Price;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends MongoRepository<Price, String> {

    @Query("{productId:'?0'}")
    Price findByProductId(String productId);
}
