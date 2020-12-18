package com.emd.proyectof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emd.proyectof.exception.ModeloNotFoundException;
import com.emd.proyectof.model.Alumno;
import com.emd.proyectof.model.Apoderado;
import com.emd.proyectof.service.IApoderadoService;

@RestController
@RequestMapping("/apoderados")
public class ApoderadoController {
	
	@Autowired
	private IApoderadoService service;
	
	@GetMapping
	public ResponseEntity<List<Apoderado>> listar(){
		List<Apoderado> lista = service.listar();
		return new ResponseEntity<List<Apoderado>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Apoderado> listarPorId(@PathVariable("id") Integer id){
		Apoderado apoderado = service.leerPorId(id);
		if(apoderado.getIdApoderado() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");	
		}
		return new ResponseEntity<Apoderado> (apoderado, HttpStatus.OK);
	}

}
