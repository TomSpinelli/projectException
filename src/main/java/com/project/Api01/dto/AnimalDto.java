package com.project.Api01.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AnimalDto(

        @NotBlank(message = "nome obrigatorio")
        String nome,
        String especie,
        @NotNull
        @Positive
        Long idade


) {


        public AnimalDto(@NotBlank(message = "nome obrigatorio")
                         String nome, String especie, @NotNull
                         @Positive
                         Long idade) {
                this.nome = nome;
                this.especie = especie;
                this.idade = idade;
        }
}
