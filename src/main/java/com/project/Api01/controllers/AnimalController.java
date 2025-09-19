package com.project.Api01.controllers;

import com.project.Api01.models.Animal;
import com.project.Api01.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    //GET
    @GetMapping("{id}")
    public Animal buscarPorId(@PathVariable Long id){
        return animalService.buscarPorId(id);
    }

    @GetMapping("/buscar/nome/{nome}")
    public Animal buscarPorNome(@PathVariable String nome){
        return animalService.buscarPorNome(nome);
    }

    @GetMapping("/listar/especie/{especie}")
    public List<Animal> listarPorEspecie(@PathVariable String especie){
        return animalService.buscarPorEspecie(especie);
    }

    @GetMapping("/listar/idade/{idade}")
    public List<Animal> listarPorIdade(@PathVariable Long idade){
        return animalService.buscarPorIdade(idade);
    }

    @GetMapping("/listar/idade/maior/{idade}")
    public List<Animal> listarPorIdadeMaiorQue(@PathVariable Long idade){
        return animalService.buscarPorIdadeMaiorQue(idade);
    }

    //DELETE
    @DeleteMapping("{id}")
    public void apagar(@PathVariable Long id){
        animalService.apagar(id);
    }

    //POST
    @PostMapping("{id}")
    public Animal salvar(@RequestBody Animal animal){
        return animalService.salvar(animal);
    }

    //PUT
    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Animal animal){
        animalService.update(id ,animal);
    }

}
