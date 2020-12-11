package com.emd.proyectof.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emd.proyectof.exception.ModeloNotFoundException;
import com.emd.proyectof.model.Test;
import com.emd.proyectof.service.ITestService;

@RestController
@RequestMapping("/tests")
public class TestController {
	
	@Autowired
	private ITestService service;
	
	@GetMapping
	public ResponseEntity<List<Test>> listar(){
		List<Test> lista = service.listar();
		return new ResponseEntity<List<Test>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Test> listarPorId(@PathVariable("id") Integer id) {
		Test test = service.leerPorId(id);
		if (test.getIdTest() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		return new ResponseEntity<Test>(test, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Test test) {
		Test obj = service.registrar(test);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(test.getIdTest()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Test> modificar(@Valid @RequestBody Test test) {
		Test obj = service.modificar(test);
		return new ResponseEntity<Test>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Test test = service.leerPorId(id);
		if (test.getIdTest() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
