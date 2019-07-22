package com.student.rest_tutorial.repository;

import com.student.rest_tutorial.models.Topic;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends MongoRepository<Topic,String> {


}
