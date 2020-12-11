package com.emd.proyectof.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evaluacion")
public class Evaluacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvaluacion;
	
	private LocalDateTime fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "evaluacion_alumno_FK"))
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "id_asignatura", nullable = false, foreignKey = @ForeignKey(name = "evaluacion_asignatura_FK"))
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name = "id_evaluador", nullable = false, foreignKey = @ForeignKey(name = "evaluacion_evaluador_FK"))
	private Evaluador evaluador;
	
	@OneToMany(mappedBy = "evaluacion", cascade = { CascadeType.ALL}, orphanRemoval = true)
    private List<DetalleEvaluacion> detalleEvaluacion;

	public Integer getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Integer id_evaluacion) {
		this.idEvaluacion = id_evaluacion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Evaluador getEvaluador() {
		return evaluador;
	}

	public void setEvaluador(Evaluador evaluador) {
		this.evaluador = evaluador;
	}

	public List<DetalleEvaluacion> getDetalleEvaluacion() {
		return detalleEvaluacion;
	}

	public void setDetalleEvaluacion(List<DetalleEvaluacion> detalleEvaluacion) {
		this.detalleEvaluacion = detalleEvaluacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvaluacion == null) ? 0 : idEvaluacion.hashCode());
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
		Evaluacion other = (Evaluacion) obj;
		if (idEvaluacion == null) {
			if (other.idEvaluacion != null)
				return false;
		} else if (!idEvaluacion.equals(other.idEvaluacion))
			return false;
		return true;
	}
}
