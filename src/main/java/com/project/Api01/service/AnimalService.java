package com.project.Api01.service;

import com.project.Api01.dto.AnimalDto;
import com.project.Api01.models.Animal;
import com.project.Api01.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService{

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public AnimalDto buscarPorId(Long aLong){
        Optional<Animal> animal = animalRepository.findById(aLong);
        return criarDto(animal.get());
    }

    public AnimalDto buscarPorNome(String nome){
        Optional<Animal> animal = animalRepository.findByNome(nome);
        return criarDto(animal.get());
    }

    public List<AnimalDto> buscarPorEspecie(String especie){
        return animalRepository.findByEspecie(especie).stream().map(
                this::criarDto
        ).toList();
    }

    public List<AnimalDto> buscarPorIdade(Long aLong){
        return animalRepository.findByIdade(aLong).stream().map(
                this::criarDto
        ).toList();
    }

    public List<AnimalDto> buscarPorIdadeMaiorQue(Long aLong){
        return animalRepository.findByIdadeGreaterThan(aLong).stream().map(
                this::criarDto
        ).toList();
    }

    public Animal salvar(AnimalDto dto){
        Animal animal = criarAnimal(dto);
        return animalRepository.save(animal);
    }

    public Animal update(Long id, AnimalDto animalDto){
        animalRepository.findById(id).orElseThrow(() ->new RuntimeException("Animal não existe"));
        Animal animal = criarAnimal(animalDto);
        animal.setId(id);
        return animalRepository.save(animal);
    }

    public void apagar(Long id){
        animalRepository.deleteById(id);
    }

    public Animal criarAnimal(AnimalDto dto){
        return Animal.builder().idade(dto.idade()).especie(dto.especie()).nome(dto.nome()).build();
    }

    public AnimalDto criarDto(Animal animal){
        return new AnimalDto(animal.getNome(),animal.getEspecie(), animal.getIdade());
    }




}
