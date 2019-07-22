package com.student.rest_tutorial.repository;

import com.student.rest_tutorial.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetsRepository extends MongoRepository<Pets, String>{

    Pets findBy_id(ObjectId _id);

    Page<Pets> findByName (String petsName, Pageable page);
}