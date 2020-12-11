package com.emd.proyectof.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.emd.proyectof.dto.EvaluacionDTO;
import com.emd.proyectof.dto.EvaluacionListaTestDTO;
import com.emd.proyectof.dto.EvaluacionResumenDTO;
import com.emd.proyectof.dto.FiltroEvaluacionDTO;
import com.emd.proyectof.exception.ModeloNotFoundException;
import com.emd.proyectof.model.Archivo;
import com.emd.proyectof.model.Evaluacion;
import com.emd.proyectof.service.IArchivoService;
import com.emd.proyectof.service.IEvaluacionService;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
	
	@Autowired
	private IEvaluacionService service;
	
	@Autowired
	private IArchivoService serviceArchivo;
	
	@GetMapping
	public ResponseEntity<List<Evaluacion>> listar(){
		List<Evaluacion> lista = service.listar();
		return new ResponseEntity<List<Evaluacion>> (lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Evaluacion> listarPorId(@PathVariable("id") Integer id){
		Evaluacion evaluacion = service.leerPorId(id);
		if(evaluacion.getIdEvaluacion() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		return new ResponseEntity<Evaluacion> (evaluacion, HttpStatus.OK);
	}
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EvaluacionDTO> listarHateoas(){
		List<Evaluacion> evaluaciones = new ArrayList<>();
		List<EvaluacionDTO> evaluacionesDTO = new ArrayList<>();
		evaluaciones = service.listar();
		
		for(Evaluacion e : evaluaciones) {
			EvaluacionDTO d = new EvaluacionDTO();
			d.setIdEvaluacion(e.getIdEvaluacion());
			d.setEvaluador(e.getEvaluador());
			d.setAlumno(e.getAlumno());
			
			ControllerLinkBuilder linkTo = linkTo(methodOn(EvaluacionController.class).listarPorId((e.getIdEvaluacion())));
			d.add(linkTo.withSelfRel());
			evaluacionesDTO.add(d);	
		}
		return evaluacionesDTO;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody EvaluacionListaTestDTO evaluacionDTO){
		Evaluacion evalua = service.registrarTransaccional(evaluacionDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(evalua.getIdEvaluacion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Evaluacion> modificar(@Valid @RequestBody Evaluacion evaluacion){
		Evaluacion evalua = service.modificar(evaluacion);
		return new ResponseEntity<Evaluacion>(evalua, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Evaluacion evaluacion = service.leerPorId(id);
		if(evaluacion.getIdEvaluacion() == null) {
			throw new ModeloNotFoundException("EL ID: " + id + " NO FUE ENCONTRADO");
		}
		service.eliminar(id);
		return new ResponseEntity<Object> (HttpStatus.OK);
	}
	
	@PostMapping("/buscar")
	public ResponseEntity<List<Evaluacion>> buscar(@RequestBody FiltroEvaluacionDTO filtro){
		List<Evaluacion> evaluaciones = new ArrayList<>();
		if(filtro.getFechaEvaluacion() != null) {
			evaluaciones = service.buscarFecha(filtro);
		} else {
			evaluaciones = service.buscar(filtro);
		}
		return new ResponseEntity<List<Evaluacion>>(evaluaciones, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<EvaluacionResumenDTO>> listarResumen() {
		List<EvaluacionResumenDTO> evaluaciones = new ArrayList<>();
		evaluaciones = service.listarResumen();
		return new ResponseEntity<List<EvaluacionResumenDTO>>(evaluaciones, HttpStatus.OK);
	}
	
	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(){
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());
		
		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}

}
