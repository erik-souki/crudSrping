package com.erik.crudspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.erik.crudspring.model.Student;
import com.erik.crudspring.repository.StudentRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    
    private final StudentRepository studentRepository;



    @GetMapping
    public @ResponseBody List<Student> list(){
        return studentRepository.findAll();
    }
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student create(@RequestBody Student student){
        //System.out.println(student.getName());
        return studentRepository.save(student);
        //return ResponseEntity.status(HttpStatus.CREATED)
        //    .body(studentRepository.save(student));
    }
    
}
