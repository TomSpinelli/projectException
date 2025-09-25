package com.project.Api01.service;

import com.project.Api01.dto.GymAlunoDto;
import com.project.Api01.models.GymAluno;
import com.project.Api01.repositories.GymAlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GymAlunoService {


    public GymAlunoDto buscarPorId(Long aLong);

    public GymAlunoDto buscarPorNome(String nome);

    public List<GymAlunoDto> buscarPorIdade(Long aLong);

    public GymAluno salvar(GymAlunoDto dto);

    public GymAluno update(Long id, GymAlunoDto gymAlunoDto);

    public void apagar(Long id);





}
