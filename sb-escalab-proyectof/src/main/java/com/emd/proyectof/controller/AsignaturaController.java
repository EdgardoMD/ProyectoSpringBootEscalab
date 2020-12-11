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
import com.emd.proyectof.model.Asignatura;
import com.emd.proyectof.service.IAsignaturaService;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
	
	@Autowired
	private IAsignaturaService service;
	
	@GetMapping
	public ResponseEntity<List<Asignatura>> listar(){
		List<Asignatura> lista = service.listar();
		return new ResponseEntity<List<Asignatura>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Asignatura> listarPorId(@PathVariable("id") Integer id){
		Asignatura asignatura = service.leerPorId(id);
		if(asignatura.getIdAsignatura() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		return new ResponseEntity<Asignatura> (asignatura, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Asignatura asignatura){
		Asignatura asig = service.registrar(asignatura);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(asignatura.getIdAsignatura()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Asignatura> modificar(@Valid @RequestBody Asignatura asignatura){
		Asignatura asig = service.modificar(asignatura);
		return new ResponseEntity<Asignatura> (asig, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Asignatura asignatura = service.leerPorId(id);
		if(asignatura.getIdAsignatura() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
