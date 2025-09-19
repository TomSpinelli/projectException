package com.project.Api01.service;

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

    public Animal buscarPorId(Long aLong){
        Optional<Animal> animal = animalRepository.findById(aLong);
        return animal.orElse(null);
    }

    public Animal buscarPorNome(String nome){
        Optional<Animal> animal = animalRepository.findByNome(nome);
        return animal.orElse(null);
    }

    public List<Animal> buscarPorEspecie(String especie){
        return animalRepository.findByEspecie(especie);
    }

    public List<Animal> buscarPorIdade(Long aLong){
        return animalRepository.findByIdade(aLong);
    }

    public List<Animal> buscarPorIdadeMaiorQue(Long aLong){
        return animalRepository.findByIdadeGreaterThan(aLong);
    }

    public Animal salvar(Animal animal){
        return animalRepository.save(animal);
    }

    public Animal update(Long id, Animal animal){
        animal.setId(id);
        animalRepository.findById(animal.getId()).orElseThrow(() ->new RuntimeException("Animal não existe"));
        return animalRepository.save(animal);
    }

    public void apagar(Long id){
        animalRepository.deleteById(id);
    }


}
