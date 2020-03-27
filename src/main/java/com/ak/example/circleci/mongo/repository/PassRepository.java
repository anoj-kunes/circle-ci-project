package com.ak.example.circleci.mongo.repository;

import com.ak.example.circleci.mongo.model.Pass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends MongoRepository<Pass, String> {
}
