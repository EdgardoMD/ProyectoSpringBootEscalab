package com.emd.proyectof.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "detalle_evaluacion")
public class DetalleEvaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleEvaluacion;
	
	@Column(name = "puntaje_obtenido", nullable = true)
	private Double puntajeObtenido;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_evaluacion", nullable = false, foreignKey = @ForeignKey(name = "evaluacion_detalle_FK"))
	private Evaluacion evaluacion;

	public int getIdDetalleEvaluacion() {
		return idDetalleEvaluacion;
	}

	public void setIdDetalleEvaluacion(int idDetalleEvaluacion) {
		this.idDetalleEvaluacion = idDetalleEvaluacion;
	}

	public Double getPuntajeObtenido() {
		return puntajeObtenido;
	}

	public void setPuntajeObtenido(Double puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
}
