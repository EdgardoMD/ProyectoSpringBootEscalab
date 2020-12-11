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
@Table(name = "apoderado")
public class Apoderado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idApoderado;
	
	@Size(min = 3, message = "Nombre debe tener mínimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	
	@Size(min = 3, message = "Apellido debe tener mínimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Size(min = 9, max = 10, message = "Debe ingresar digitos sin punto, CON guión y dígito verificador")
	@Column(name = "run", nullable = false, length = 10)
	private String run;
	
	@Size(min = 9, max = 9, message = "teléfono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@Email
	@Column(name = "email", nullable = true, length = 75)
	private String email;

	public Integer getIdApoderado() {
		return idApoderado;
	}

	public void setIdApoderado(Integer idApoderado) {
		this.idApoderado = idApoderado;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
