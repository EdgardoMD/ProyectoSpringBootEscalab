package com.emd.proyectof.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTest;
	
	@Size(min = 3, message = "Nombre debe tener mínimo 5 caracteres")
	@Column(name = "nombre", nullable = false, length = 75)
	private String nombre;
	
	@Column(name = "puntaje_maximo", nullable = false)
	private Double puntajeMaximo;
	
	@Column(name = "puntaje_aprobacion", nullable = false)
	private Double puntajeAprobacion;
	
	@Column(name = "descripcion", nullable = true)
	private String descripcion;

	public Integer getIdTest() {
		return idTest;
	}

	public void setIdTest(Integer idTest) {
		this.idTest = idTest;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public void setPuntajeMaximo(Double puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	public Double getPuntajeAprobacion() {
		return puntajeAprobacion;
	}

	public void setPuntajeAprobacion(Double puntajeAprobacion) {
		this.puntajeAprobacion = puntajeAprobacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTest == null) ? 0 : idTest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (idTest == null) {
			if (other.idTest != null)
				return false;
		} else if (!idTest.equals(other.idTest))
			return false;
		return true;
	}
}
