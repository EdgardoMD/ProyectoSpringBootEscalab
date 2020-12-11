package com.emd.proyectof.service;

import java.util.List;

import com.emd.proyectof.model.EvaluacionTest;

public interface IEvaluacionTestService {
	
	List<EvaluacionTest> listarTestsPorEvaluacion(Integer idEvaluacion);

}
