package com.emd.proyectof.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "evaluacion_test")
@IdClass(EvaluacionTestPK.class)
public class EvaluacionTest {
	
	@Id
	private Evaluacion evaluacion;
	
	@Id
	private Test test;

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
}
