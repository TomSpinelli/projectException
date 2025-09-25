package com.project.Api01.controllers;

import com.project.Api01.dto.GymAlunoDto;
import com.project.Api01.models.GymAluno;
import com.project.Api01.service.GymAlunoService;
import com.project.Api01.service.GymAlunoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class GymAlunoController {

    @Autowired
    private GymAlunoServiceImpl gymAlunoService;

    //GET
    @GetMapping("{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        GymAlunoDto gymAlunoDto = gymAlunoService.buscarPorId(id);
        return ResponseEntity.ok(gymAlunoDto);
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
        GymAlunoDto gymAlunoDto = gymAlunoService.buscarPorNome(nome);
        return ResponseEntity.ok(gymAlunoDto);
    }

    @GetMapping("/listar/idade/{idade}")
    public ResponseEntity<List<GymAlunoDto>> listarPorIdade(@PathVariable Long idade){
        return ResponseEntity.ok(gymAlunoService.buscarPorIdade(idade));
    }

    //DELETE
    @DeleteMapping("{id}")
    public void apagar(@PathVariable Long id){
        gymAlunoService.apagar(id);
    }

    //POST
    @PostMapping("{id}")
    public ResponseEntity<?> salvar(@Valid @RequestBody GymAlunoDto dto){
        GymAluno gymAluno = gymAlunoService.salvar(dto);
        return ResponseEntity.ok(gymAluno);
    }

    //PUT
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody GymAlunoDto dto){
        GymAluno gymAluno = gymAlunoService.update(id ,dto);
        return ResponseEntity.ok(gymAluno);
    }

}
