package com.student.rest_tutorial.service;

import com.student.rest_tutorial.models.Dogs;
import com.student.rest_tutorial.repository.DogsRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class DogService {

    @Autowired
    DogsRepository dogsRepository;


    @Autowired
    MongoTemplate mongoTemplate;


    public List<Dogs> findAll() {
        return dogsRepository.findAll();
    }

    public Dogs chooseDogById(ObjectId id) {
        Dogs dogg = dogsRepository.findBy_id(id);
        return dogg;
    }

    public Dogs createDog(Dogs dog) {
        dog.set_id(ObjectId.get());
        dogsRepository.save(dog);
        return dog;
    }

    public Dogs udpateDog(Dogs dog,String id) {
        Optional<Dogs> dogById = dogsRepository.findById(id);
        if(dog == null){
            return null;
        }
        dogById.get().setName(dog.getName());
        dogById.get().setBreed(dog.getBreed());
        dogById.get().setSpecies(dog.getSpecies());
        return dogsRepository.save(dogById.get());
    }

    public void deleteById(ObjectId id) {
        dogsRepository.delete(dogsRepository.findBy_id(id));
    }

    public Page<Dogs> paginate (String dogname,int page, int size){
        Pageable pageableRequest = PageRequest.of(page, size);
        Page<Dogs> pageOfDogs = dogsRepository.findAllByName(dogname,pageableRequest);
        return  pageOfDogs;
    }


    public List <Dogs> findByCriteria (Dogs dogs,int page,int size){

        Query dynamicQuery = new Query().with( new PageRequest(page,size));
        Criteria criteria= new Criteria();


        if (dogs.getName() != null) {
            dynamicQuery.addCriteria(criteria.orOperator(where("name").is(dogs.getName())));
        }
        else if ( dogs.getBreed()!=null ){
            dynamicQuery.addCriteria(criteria.orOperator(criteria.where("breed").is(dogs.getBreed())));
        }
        else if ( dogs.getSpecies()!=null){
            dynamicQuery.addCriteria(criteria.orOperator(criteria.where("species").is(dogs.getSpecies())));
        }



        List<Dogs> result = mongoTemplate.find(dynamicQuery, Dogs.class, "dogs");
        return result;

    }

}
