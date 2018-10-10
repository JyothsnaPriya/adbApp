package com.verizon.sdme.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.sdme.model.EmployeeMongo;

@Repository
public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongo, Integer>{

}
