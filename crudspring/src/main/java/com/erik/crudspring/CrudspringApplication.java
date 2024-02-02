package com.erik.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.erik.crudspring.model.Student;
import com.erik.crudspring.repository.StudentRepository;

@SpringBootApplication
public class CrudspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudspringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(StudentRepository studentRepository){
		return args -> {
			studentRepository.deleteAll();

			Student s = new Student();
			s.setName("Arthur");
			s.setRa(012);
			s.setTeam("Amarelo");

			studentRepository.save(s);
		};
	}

}
