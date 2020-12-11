package com.emd.proyectof.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Test;
import com.emd.proyectof.repo.ITestRepo;
import com.emd.proyectof.service.ITestService;

@Service
public class TestServiceImpl implements ITestService{
	
	@Autowired 
	private ITestRepo repo;

	@Override
	public Test registrar(Test test) {
		
		return repo.save(test);
	}

	@Override
	public Test modificar(Test test) {
		
		return repo.save(test);
	}

	@Override
	public List<Test> listar() {
		
		return repo.findAll();
	}

	@Override
	public Test leerPorId(Integer id) {
		Optional<Test> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Test();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
