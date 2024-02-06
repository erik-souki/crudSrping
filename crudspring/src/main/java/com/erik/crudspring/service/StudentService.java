package com.erik.crudspring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;


import com.erik.crudspring.repository.StudentRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import com.erik.crudspring.exception.RecordNotFoundException;
import com.erik.crudspring.model.Student;

@Validated
@Service
public class StudentService {

    private final StudentRepository studentRepository;

 
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public @ResponseBody List<Student> list(){
        return studentRepository.findAll();
    }

    public Student findById(@PathVariable @NotNull @Positive Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Student create (@Valid Student student) {
        return studentRepository.save(student);
    }

    public Student update( @NotNull @ Positive Long id, @Valid Student student) {
        return studentRepository.findById(id)
        .map(recordFound -> {
            recordFound.setName(student.getName());
            recordFound.setRa(student.getRa());
            recordFound.setTeam(student.getTeam());
            return studentRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        studentRepository.delete(studentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));


    }



}