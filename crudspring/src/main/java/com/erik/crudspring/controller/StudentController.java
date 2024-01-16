package com.erik.crudspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.erik.crudspring.model.Student;
import com.erik.crudspring.repository.StudentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    
    private final StudentRepository studentRepository;



    @GetMapping
    public List<Student> list(){
        return studentRepository.findAll();
    }
    
}
