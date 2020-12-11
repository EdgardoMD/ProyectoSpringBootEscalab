package com.emd.proyectof.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.EvaluacionTest;
import com.emd.proyectof.repo.IEvaluacionTestRepo;
import com.emd.proyectof.service.IEvaluacionTestService;

@Service
public class EvaluacionTestServiceImpl implements IEvaluacionTestService{
	
	@Autowired
	private IEvaluacionTestRepo repo;

	@Override
	public List<EvaluacionTest> listarTestsPorEvaluacion(Integer idEvaluacion) {
		
		return repo.listarTestsPorEvaluacion(idEvaluacion);
	}
}
