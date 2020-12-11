package com.emd.proyectof.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emd.proyectof.model.EvaluacionTest;
import com.emd.proyectof.service.IEvaluacionTestService;

@RestController
@RequestMapping("/evaluaciontests")
public class EvaluacionTestController {
	
	@Autowired
	private IEvaluacionTestService service;
	
	@GetMapping(value = "/{idEvaluacion}")
	public ResponseEntity<List<EvaluacionTest>> listar(@PathVariable("idEvaluacion") Integer idEvaluacion) {
		List<EvaluacionTest> evaluacionestest = new ArrayList<>();
		evaluacionestest = service.listarTestsPorEvaluacion(idEvaluacion);
		return new ResponseEntity<List<EvaluacionTest>>(evaluacionestest, HttpStatus.OK);
	}

}
