package com.emd.proyectof.dto;

import java.util.List;

import com.emd.proyectof.model.Evaluacion;
import com.emd.proyectof.model.Test;

public class EvaluacionListaTestDTO {
	
	private Evaluacion evaluacion;
	private List<Test> listaTest;
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}
	public List<Test> getListaTest() {
		return listaTest;
	}
	public void setListaTest(List<Test> listaTest) {
		this.listaTest = listaTest;
	}
}
