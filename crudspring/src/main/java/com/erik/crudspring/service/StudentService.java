package com.erik.crudspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;


import com.erik.crudspring.repository.StudentRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import com.erik.crudspring.dto.StudentDTO;
import com.erik.crudspring.dto.mapper.StudentMapper;
import com.erik.crudspring.exception.RecordNotFoundException;

@Validated
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

 
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }


    public List<StudentDTO> list(){
        return studentRepository.findAll().stream().map(studentMapper::toDTO).collect(Collectors.toList());
    }

    public StudentDTO findById(@PathVariable @NotNull @Positive Long id) {
        return studentRepository.findById(id).map(studentMapper :: toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public StudentDTO create (@Valid @NotNull StudentDTO student) {
        return studentMapper.toDTO(studentRepository.save(studentMapper.toEntity((student)))) ;
    }

    public StudentDTO update( @NotNull @ Positive Long id, @Valid @NotNull StudentDTO student) {
        return studentRepository.findById(id)
        .map(recordFound -> {
            recordFound.setName(student.name());
            recordFound.setRa(student.ra());
            recordFound.setTeam(student.team());
            return studentMapper.toDTO(studentRepository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        studentRepository.delete(studentRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));


    }



}