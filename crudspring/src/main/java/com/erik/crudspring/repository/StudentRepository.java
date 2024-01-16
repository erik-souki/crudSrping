package com.erik.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erik.crudspring.model.Student;

@Repository
public interface  StudentRepository extends JpaRepository<Student, Long>{

    
}
