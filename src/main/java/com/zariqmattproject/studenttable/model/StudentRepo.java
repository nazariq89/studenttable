package com.zariqmattproject.studenttable.model;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{

    Optional<Student> findById(String id);
}
