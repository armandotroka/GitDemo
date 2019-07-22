package com.student.rest_tutorial.controller;

import com.student.rest_tutorial.models.Pets;
import com.student.rest_tutorial.repository.PetsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    PetsRepository petsRepository;

    @GetMapping("/pets")
    public List<Pets> getPets() {
        return petsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pets getPetById(@PathVariable("id") ObjectId id) {
        return petsRepository.findBy_id(id);
    }

    @PutMapping("/{id}")
    public void modifyPetById(@PathVariable("id") ObjectId id, @RequestBody Pets pets) {
        pets.set_id(id);
        petsRepository.save(pets);
    }

    @PostMapping("/post")
    public Pets createPet(@RequestBody Pets pets) {
//        pets.set_id(ObjectId.get());
        petsRepository.save(pets);
        return pets;
    }

    @DeleteMapping("/{id}")
    public void deletePet (@PathVariable ObjectId id){
       petsRepository.delete(petsRepository.findBy_id(id));
    }

}
