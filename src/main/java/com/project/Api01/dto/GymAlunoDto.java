package com.project.Api01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record GymAlunoDto(

        @NotBlank(message = "nome obrigatorio")
        @Size(max = 20)
        String nome,

        @NotBlank(message = "modalidade obrigatorio")
        @Size(max = 20)
        String modalidade,

        @NotNull
        @Positive
        Long idade


) {

}
