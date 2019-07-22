package com.student.rest_tutorial.repository;

import com.student.rest_tutorial.models.Dogs;
import com.student.rest_tutorial.models.Pets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationExRepository extends MongoRepository <Dogs,String> {

 Page<Dogs> findAll(Pageable pageable);



}

