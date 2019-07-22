package com.student.rest_tutorial.controller;

import com.student.rest_tutorial.models.Student;
import com.student.rest_tutorial.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping ("/getAll")
    public List<Student>getAllStudent(){
        return studentService.getAll();
    }

    @GetMapping("/student/{id}")
    public Optional <Student> getStudent(@PathVariable String id){
        System.out.print("id eshte" + id);
        return studentService.getStudentById(id);
    }

    @PostMapping ("/post")
    public Student postStudent(@RequestBody Student student){
        return studentService.create(student);
    }

    @PutMapping ("/update/{id}")
    public Student updateStudent (@RequestBody Student student,@PathVariable String id){
        return studentService.update(student,id);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteStudent (@PathVariable String id){
         studentService.deleteStudent(id);
    }
}
