package com.emd.proyectof.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emd.proyectof.model.Alumno;

public interface IAlumnoService extends ICRUD<Alumno>{
	
	Page<Alumno> listarPageable(Pageable pageable);

}
