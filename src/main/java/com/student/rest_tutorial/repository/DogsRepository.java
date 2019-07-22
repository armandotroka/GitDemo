package com.student.rest_tutorial.repository;

import com.querydsl.core.types.Predicate;
import com.student.rest_tutorial.models.Dogs;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DogsRepository extends MongoRepository <Dogs,String> {

    Dogs findBy_id(ObjectId id);

    Page<Dogs> findAllByName(String dogname, Pageable pageable);

    Page <Dogs>findAll(Pageable pageable);

}
