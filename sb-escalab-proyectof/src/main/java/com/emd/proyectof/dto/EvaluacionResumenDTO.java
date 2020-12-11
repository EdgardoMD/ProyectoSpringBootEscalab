package com.emd.proyectof.dto;

public class EvaluacionResumenDTO {
	
	private Integer cantidad;
	private String fecha;
	
	public EvaluacionResumenDTO() {
	}

	public EvaluacionResumenDTO(Integer cantidad, String fecha) {
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
