package com.emd.proyectof.dto;

import org.springframework.hateoas.ResourceSupport;

import com.emd.proyectof.model.Alumno;
import com.emd.proyectof.model.Evaluador;


public class EvaluacionDTO extends ResourceSupport{
	
	private Integer idEvaluacion;
	private Alumno alumno;
	private Evaluador evaluador;
	
	public Integer getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(Integer idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Evaluador getEvaluador() {
		return evaluador;
	}
	public void setEvaluador(Evaluador evaluador) {
		this.evaluador = evaluador;
	}
	
	

}
