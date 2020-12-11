package com.emd.proyectof.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.emd.proyectof.model.Alumno;
import com.emd.proyectof.service.IAlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> listar(){
		List<Alumno> lista = service.listar();
		return new ResponseEntity<List<Alumno>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id){
		Alumno alumno = service.leerPorId(id);
		if(alumno.getIdAlumno() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		return new ResponseEntity<Alumno> (alumno, HttpStatus.OK);
	}
	
	//Nivel 1
	@GetMapping("/pageable")
	public ResponseEntity<Page<Alumno>> listarPageable(Pageable pageable){
		
		Page<Alumno> alumnos = service.listarPageable(pageable);
		return new ResponseEntity<Page<Alumno>> (alumnos, HttpStatus.OK);	
	}
	
	//Nivel 2
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Alumno alumno){
		Alumno alum = service.registrar(alumno);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alumno.getIdAlumno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Alumno> modificar(@Valid @RequestBody Alumno alumno){
		Alumno alum = service.modificar(alumno);
		return new ResponseEntity<Alumno> (alum, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Alumno alumno = service.leerPorId(id);
		if(alumno.getIdAlumno() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);	
	}
}
