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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información del Alumno")
@Entity
@Table(name = "alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@Size(min = 3, message = "Nombres debe tener mínimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Size(min = 3, message = "Apellido debe tener mínimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellidos;
	
	@Size(min = 9, max = 10, message = "Debe ingresar digitos sin punto y CON guión")
	@Column(name = "run", nullable = false, length = 10)
	private String run;
	
	@ManyToOne
	@JoinColumn(name = "id_apoderado", nullable = false, foreignKey = @ForeignKey(name = "alumno_apoderado_fk"))
	private Apoderado apoderado;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}
}
