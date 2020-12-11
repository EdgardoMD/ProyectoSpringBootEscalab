package com.emd.proyectof.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "evaluador")
public class Evaluador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvaluador;
	
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Size(min = 3, message = "Apellido debe tener mínimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Size(min = 9, max = 10, message = "Debe ingresar digitos sin punto y CON guión")
	@Column(name = "run", nullable = false, length = 10)
	private String run;
	
	@Email
	@Column(name = "email", nullable = true, length = 75)
	private String email;

	public Integer getIdEvaluador() {
		return idEvaluador;
	}

	public void setIdEvaluador(Integer idEvaluador) {
		this.idEvaluador = idEvaluador;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
