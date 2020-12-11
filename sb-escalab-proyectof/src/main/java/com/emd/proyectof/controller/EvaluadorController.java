package com.emd.proyectof.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.emd.proyectof.model.Evaluador;
import com.emd.proyectof.service.IEvaluadorService;

@RestController
@RequestMapping("/evaluadores")
public class EvaluadorController {
	
	@Autowired
	private IEvaluadorService service;
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Evaluador>> listar(){
		List<Evaluador> lista = service.listar();
		return new ResponseEntity<List<Evaluador>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evaluador> listarPorId(@PathVariable("id") Integer id){
		Evaluador evaluador = service.leerPorId(id);
		if(evaluador.getIdEvaluador() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		return new ResponseEntity<Evaluador> (evaluador, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Evaluador evaluador){
		Evaluador eva = service.registrar(evaluador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evaluador.getIdEvaluador()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Evaluador> modificar(@Valid @RequestBody Evaluador evaluador){
		Evaluador eva = service.modificar(evaluador);
		return new ResponseEntity<Evaluador> (eva, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Evaluador evaluador = service.leerPorId(id);
		if(evaluador.getIdEvaluador() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	

}
