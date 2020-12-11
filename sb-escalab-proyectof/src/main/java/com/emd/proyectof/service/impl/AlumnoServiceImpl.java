package com.emd.proyectof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Alumno;
import com.emd.proyectof.repo.IAlumnoRepo;
import com.emd.proyectof.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepo repo;

	@Override
	public Alumno registrar(Alumno alumno) {
		
		return repo.save(alumno);
	}

	@Override
	public Alumno modificar(Alumno alumno) {
		
		return repo.save(alumno);
	}

	@Override
	public List<Alumno> listar() {
		
		return repo.findAll();
	}

	@Override
	public Alumno leerPorId(Integer id) {
		Optional<Alumno> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Alumno();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Alumno> listarPageable(Pageable pageable) {
		
		return repo.findAll(pageable);
	}
}
