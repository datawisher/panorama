package com.honeywell.mom.base.mongo.repository;

import com.honeywell.mom.base.mongo.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
