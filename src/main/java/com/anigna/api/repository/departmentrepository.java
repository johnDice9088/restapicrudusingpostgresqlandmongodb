package com.anigna.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anigna.api.model.Department;

public interface departmentrepository extends MongoRepository<Department, Long>{

}
