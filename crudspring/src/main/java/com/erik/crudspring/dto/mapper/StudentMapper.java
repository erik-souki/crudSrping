package com.erik.crudspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.erik.crudspring.dto.StudentDTO;
import com.erik.crudspring.dto.TimesDTO;
import com.erik.crudspring.model.Student;
import com.erik.crudspring.model.Times;

@Component
public class StudentMapper {

    public StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        Times time = student.getTimes();
        if (time == null) {

            // Handle the case where there's no related Times entity
            // For example, you might return a DTO with null values or throw an exception
            return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getRa(),
                student.getTeam(),
                null
            );
        }

        TimesDTO timesDTO = new TimesDTO(time.getId(), time.getTimeOne(), time.getTimeTwo());

        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getRa(),
            student.getTeam(),
            timesDTO
        );
    }

    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student student = new Student();
        if (studentDTO.id() != null) {
            student.setId(studentDTO.id());
        }
        student.setName(studentDTO.name());
        student.setRa(studentDTO.ra());
        student.setTeam(studentDTO.team());
        return student;
    }
  
}
