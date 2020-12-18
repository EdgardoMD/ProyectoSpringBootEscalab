package com.emd.proyectof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Apoderado;
import com.emd.proyectof.repo.IApoderadoRepo;
import com.emd.proyectof.service.IApoderadoService;

@Service
public class ApoderadoServiceImpl implements IApoderadoService{

	@Autowired
	private IApoderadoRepo repo;
	
	@Override
	public Apoderado registrar(Apoderado apoderado) {
		
		return repo.save(apoderado);
	}

	@Override
	public Apoderado modificar(Apoderado apoderado) {
		
		return repo.save(apoderado);
	}

	@Override
	public List<Apoderado> listar() {
		
		return repo.findAll() ;
	}

	@Override
	public Apoderado leerPorId(Integer id) {
		
		Optional<Apoderado> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Apoderado();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
