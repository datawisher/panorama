package com.honeywell.mom.base.mongo.repository;

import com.honeywell.mom.base.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Object> {
}
