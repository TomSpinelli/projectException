package com.project.Api01.repositories;

import com.project.Api01.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

    Optional<Animal> findByNome(String nome);

    List<Animal> findByIdade(Long idade);

    List<Animal> findByIdadeGreaterThan(Long idade);

    List<Animal> findByEspecie(String especie);

}
