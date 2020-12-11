package com.emd.proyectof.dto;

import java.time.LocalDateTime;

public class FiltroEvaluacionDTO {
	
	private String run;
	private String nombreCompleto;
	private LocalDateTime fechaEvaluacion;
	public String getRun() {
		return run;
	}
	public void setRun(String run) {
		this.run = run;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDateTime getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
}
