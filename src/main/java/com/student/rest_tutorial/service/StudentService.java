package com.student.rest_tutorial.service;

import com.student.rest_tutorial.models.Student;
import com.student.rest_tutorial.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll (){
        return studentRepository.findAll();
    }


    public Optional<Student> getStudentById (String id){
        return studentRepository.findById(id);
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update (Student student,String id){
        Optional <Student>findStudentById=studentRepository.findById(id);
        if (student == null){
            return null;
        } else {
            findStudentById.get().setName(student.getName());
            findStudentById.get().setAverage(student.getAverage());
            findStudentById.get().setAverage(student.getAverage());
        }
        return studentRepository.save(findStudentById.get());
    }

    public void deleteStudent (String id){
        studentRepository.deleteById(id);
    }
}
