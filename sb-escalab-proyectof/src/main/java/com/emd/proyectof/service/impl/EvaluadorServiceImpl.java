package com.emd.proyectof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Evaluador;
import com.emd.proyectof.repo.IEvaluadorRepo;
import com.emd.proyectof.service.IEvaluadorService;

@Service
public class EvaluadorServiceImpl implements IEvaluadorService{

	@Autowired
	private IEvaluadorRepo repo;
	
	@Override
	public Evaluador registrar(Evaluador evaluador) {
		
		return repo.save(evaluador);
	}

	@Override
	public Evaluador modificar(Evaluador evaluador) {
		
		return repo.save(evaluador);
	}

	@Override
	public List<Evaluador> listar() {
		
		return repo.findAll();
	}

	@Override
	public Evaluador leerPorId(Integer id) {
		Optional<Evaluador> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Evaluador();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
