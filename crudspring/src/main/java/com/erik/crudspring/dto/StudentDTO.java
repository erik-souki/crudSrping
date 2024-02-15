package com.erik.crudspring.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.erik.crudspring.model.Times;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @NotNull @Length(min = 3, max = 60) String name,
    @NotNull long ra,
    @NotBlank @NotNull String team,
    TimesDTO times) {


    

}
