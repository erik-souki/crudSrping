package com.erik.crudspring.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.erik.crudspring.dto.StudentDTO;
import com.erik.crudspring.dto.TimesDTO;
import com.erik.crudspring.model.Student;

@Component
public class StudentMapper {

    public StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }
        List<TimesDTO> times = student.getTimes()
        .stream()
        .map(time -> new TimesDTO(time.getId(), time.getTimeOne(), time.getTimeTwo()))
        .collect(Collectors.toList());

        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getRa(),
            student.getTeam(),
            times
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
