package com.student.rest_tutorial.service;

import com.student.rest_tutorial.models.Dogs;
import com.student.rest_tutorial.models.Pets;
import com.student.rest_tutorial.repository.DogsRepository;
import com.student.rest_tutorial.repository.PaginationExRepository;
import com.student.rest_tutorial.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationExService {

    @Autowired
    PaginationExRepository paginationExRepository;
    @Autowired
    PetsRepository petsRepository;


    public Page<Dogs> doPagination(int page,int size){
        Pageable pageable= PageRequest.of(page, size);
        Page <Dogs> dogsPage=paginationExRepository.findAll(pageable);
        return dogsPage;
    }

    public Page<Pets> Paginate (String petsName, int page, int size){
        Pageable pageable =PageRequest.of(page,size) ;
        Page<Pets> petsPage=petsRepository.findByName(petsName,pageable);
        return petsPage;
    }

}
