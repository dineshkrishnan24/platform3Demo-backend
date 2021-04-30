package com.platform3.demoproject.repository;

import com.platform3.demoproject.models.Claim;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends MongoRepository<Claim,String> {
}
