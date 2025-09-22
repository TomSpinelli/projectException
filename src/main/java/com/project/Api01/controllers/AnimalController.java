package com.project.Api01.controllers;

import com.project.Api01.dto.AnimalDto;
import com.project.Api01.models.Animal;
import com.project.Api01.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    //GET
    @GetMapping("{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        AnimalDto animalDto = animalService.buscarPorId(id);
        return ResponseEntity.ok(animalDto);
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
        AnimalDto animalDto = animalService.buscarPorNome(nome);
        return ResponseEntity.ok(animalDto);
    }

    @GetMapping("/listar/especie/{especie}")
    public ResponseEntity<List<AnimalDto>> listarPorEspecie(@PathVariable String especie){
        return ResponseEntity.ok(animalService.buscarPorEspecie(especie));
    }

    @GetMapping("/listar/idade/{idade}")
    public ResponseEntity<List<AnimalDto>> listarPorIdade(@PathVariable Long idade){
        return ResponseEntity.ok(animalService.buscarPorIdade(idade));
    }

    @GetMapping("/listar/idade/maior/{idade}")
    public ResponseEntity<List<AnimalDto>> listarPorIdadeMaiorQue(@PathVariable Long idade){
        return ResponseEntity.ok(animalService.buscarPorIdadeMaiorQue(idade));
    }

    //DELETE
    @DeleteMapping("{id}")
    public void apagar(@PathVariable Long id){
        animalService.apagar(id);
    }

    //POST
    @PostMapping("{id}")
    public ResponseEntity<?> salvar(@Valid @RequestBody AnimalDto dto, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(),error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Animal animal = animalService.salvar(dto);
        return ResponseEntity.ok(animal);
    }

    //PUT
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody AnimalDto dto){
        Animal animal = animalService.update(id ,dto);
        return ResponseEntity.ok(animal);
    }

}
