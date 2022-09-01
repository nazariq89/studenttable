package com.zariqmattproject.studenttable.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends MongoRepository<Class, String> {
}
