package com.target.myretail;

import com.target.myretail.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyRetailApplication {

	@Autowired
	PriceRepository priceRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyRetailApplication.class, args);
	}

}