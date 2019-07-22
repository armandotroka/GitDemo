package com.student.rest_tutorial.controller;

import com.student.rest_tutorial.models.Dogs;
import com.student.rest_tutorial.models.Pets;
import com.student.rest_tutorial.service.PaginationExService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/pagination")
public class PaginationExController {

    @Autowired
    PaginationExService paginationExService;
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping ("/{page}/{size}")
    public Page<Dogs> getAll( @PathVariable int page, @PathVariable int size){
        return paginationExService.doPagination(page, size);
    }

    @GetMapping ("/pets/{petsName}/{page}/{size}")
    public Page<Pets>getAllPAginated (@PathVariable String petsName,@PathVariable int page, @PathVariable int size){
        return paginationExService.Paginate(petsName,page,size);
    }
}
