package com.student.rest_tutorial.controller;

import com.student.rest_tutorial.models.Dogs;
import com.student.rest_tutorial.repository.DogsRepository;
import com.student.rest_tutorial.service.DogService;

import org.assertj.core.util.Lists;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogsController {

    @Autowired
    DogService dogService;
    @Autowired
    DogsRepository dogsRepository;

    @GetMapping("/dogs")
    public List<Dogs> getDogs() {
        return dogService.findAll();
    }


    @GetMapping("/{id}")
    public Dogs getDogById(@PathVariable("id") ObjectId id) {
        return dogService.chooseDogById(id);
    }

    @PostMapping("/create")
    public Dogs create (@RequestBody Dogs dog){
        return dogService.createDog(dog);
    }

    @PutMapping("/update/{id}")
    public Dogs update (@RequestBody Dogs dog, @PathVariable String id){
//         dog.set_id(id);
//         System.out.println("Dog"+dog.toString());
       return dogService.udpateDog(dog,id);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ObjectId id){
        dogService.deleteById(id);
    }


    @GetMapping("/get/{dogname}/{page}/{size}")
    public Page<Dogs> getAll(@PathVariable String dogname,@PathVariable int page,@PathVariable int size){
        return dogService.paginate(dogname,page,size);
    }

    @PostMapping ("/find/{page}/{size}")
    public List<Dogs>findMatched (@RequestBody  Dogs dogs, @PathVariable int page, @PathVariable int size){
        return dogService.findByCriteria(dogs,page,size);
    }

}

