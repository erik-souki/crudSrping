package com.erik.crudspring.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;

    @NotBlank 
    @NotNull 
    @Length(min = 3, max = 60)
    @Column(length = 60, nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private long ra;

    @NotBlank 
    @NotNull 
    @Column(length = 20, nullable = false)
    private String team;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
    // //@JoinColumn(name = "student_id")
    // private List<Times> times = new ArrayList<>();
    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "student")
    //@JoinColumn(name = "student_id", nullable = false)
    private Times times;
}
