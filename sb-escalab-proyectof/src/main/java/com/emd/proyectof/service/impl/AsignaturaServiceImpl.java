package com.emd.proyectof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Asignatura;
import com.emd.proyectof.repo.IAsignaturaRepo;
import com.emd.proyectof.service.IAsignaturaService;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{
	
	@Autowired
	private IAsignaturaRepo repo;

	@Override
	public Asignatura registrar(Asignatura asignatura) {
		
		return repo.save(asignatura);
	}

	@Override
	public Asignatura modificar(Asignatura asignatura) {
		
		return repo.save(asignatura);
	}

	@Override
	public List<Asignatura> listar() {
		
		return repo.findAll();
	}

	@Override
	public Asignatura leerPorId(Integer id) {
		Optional<Asignatura> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Asignatura();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
