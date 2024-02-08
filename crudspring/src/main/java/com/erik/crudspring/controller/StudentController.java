package com.erik.crudspring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.erik.crudspring.dto.StudentDTO;

import com.erik.crudspring.service.StudentService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Validated
@RestController
@RequestMapping("/api/student")
public class StudentController {

    

    private final StudentService  studentService;

    public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }



    @GetMapping
    public List<StudentDTO> list() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable @NotNull @Positive Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentDTO create(@RequestBody @Valid @NotNull StudentDTO student){
        return studentService.create(student);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable @NotNull @ Positive Long id,
            @RequestBody @Valid @NotNull StudentDTO student) {
        return studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        studentService.delete(id);
                  
    }
    
}
