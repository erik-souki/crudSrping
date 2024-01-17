package com.erik.crudspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.erik.crudspring.model.Student;
import com.erik.crudspring.repository.StudentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    
    private final StudentRepository studentRepository;



    @GetMapping
    public @ResponseBody List<Student> list(){
        return studentRepository.findAll();
    }
    
}
