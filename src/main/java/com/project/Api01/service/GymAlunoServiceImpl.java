package com.project.Api01.service;

import com.project.Api01.dto.GymAlunoDto;
import com.project.Api01.exception.ResourceNotFoundException;
import com.project.Api01.models.GymAluno;
import com.project.Api01.repositories.GymAlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GymAlunoServiceImpl implements GymAlunoService {
    private GymAlunoRepository gymAlunoRepository;

    public GymAlunoServiceImpl(GymAlunoRepository gymAlunoRepository) {
        this.gymAlunoRepository = gymAlunoRepository;
    }

    public Page<GymAlunoDto> buscarTodos(int page, int size, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return gymAlunoRepository.findAll(pageable).map(
                this::criarDto
        );
    }

    @Override
    public GymAlunoDto buscarPorId(Long aLong){
        GymAluno aluno = gymAlunoRepository.findById(aLong).orElseThrow(()-> new ResourceNotFoundException("Aluno não encontrado"));

        return criarDto(aluno);
    }

    @Override
    public GymAlunoDto buscarPorNome(String nome){
        GymAluno aluno = gymAlunoRepository.findByNome(nome).orElseThrow(()-> new ResourceNotFoundException("Aluno não encontrado"));
        return criarDto(aluno);
    }

    @Override
    public List<GymAlunoDto> buscarPorIdade(Long aLong){
        return gymAlunoRepository.findByIdade(aLong).stream().map(
                this::criarDto
        ).toList();
    }

    @Override
    public GymAluno salvar(GymAlunoDto dto){
        GymAluno gymAluno = criarGymAluno(dto);
        return gymAlunoRepository.save(gymAluno);
    }

    @Override
    public GymAluno update(Long id, GymAlunoDto gymAlunoDto){
        gymAlunoRepository.findById(id).orElseThrow(() ->new RuntimeException("Aluno não existe"));
        GymAluno gymAluno = criarGymAluno(gymAlunoDto);
        gymAluno.setId(id);
        return gymAlunoRepository.save(gymAluno);
    }

    @Override
    public void apagar(Long id){
        gymAlunoRepository.deleteById(id);
    }

    public GymAluno criarGymAluno(GymAlunoDto dto){
        return GymAluno.builder().idade(dto.idade()).modalidade(dto.modalidade()).nome(dto.nome()).build();
    }

    public GymAlunoDto criarDto(GymAluno gymAluno){
        return new GymAlunoDto(gymAluno.getNome(), gymAluno.getModalidade(), gymAluno.getIdade());
    }



}
