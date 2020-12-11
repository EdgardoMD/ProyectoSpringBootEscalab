package com.emd.proyectof.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emd.proyectof.model.Archivo;


public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {
	
}
