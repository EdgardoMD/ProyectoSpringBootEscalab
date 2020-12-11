package com.emd.proyectof.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emd.proyectof.model.Curso;

public interface ICursoRepo extends JpaRepository<Curso, Integer> {

}
