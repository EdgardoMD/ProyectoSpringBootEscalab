package com.emd.proyectof.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emd.proyectof.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, Integer> {
	

}
