package com.emd.proyectof.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EvaluacionTestPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_evaluacion", nullable = false)
	private Evaluacion evaluacion;
	
	@ManyToOne
	@JoinColumn(name = "id_test", nullable = false)
	private Test test;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evaluacion == null) ? 0 : evaluacion.hashCode());
		result = prime * result + ((test == null) ? 0 : test.hashCode());
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
		EvaluacionTestPK other = (EvaluacionTestPK) obj;
		if (evaluacion == null) {
			if (other.evaluacion != null)
				return false;
		} else if (!evaluacion.equals(other.evaluacion))
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		return true;
	}
}
