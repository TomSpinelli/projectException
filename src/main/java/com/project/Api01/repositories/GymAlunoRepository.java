package com.project.Api01.repositories;

import com.project.Api01.models.GymAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymAlunoRepository extends JpaRepository<GymAluno,Long> {

    Optional<GymAluno> findByNome(String nome);

    List<GymAluno> findByIdade(Long idade);

    List<GymAluno> findByIdadeGreaterThan(Long idade);

}
