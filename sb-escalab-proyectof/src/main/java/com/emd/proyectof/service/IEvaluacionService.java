package com.emd.proyectof.service;

import java.util.List;

import com.emd.proyectof.dto.EvaluacionListaTestDTO;
import com.emd.proyectof.dto.EvaluacionResumenDTO;
import com.emd.proyectof.dto.FiltroEvaluacionDTO;
import com.emd.proyectof.model.Evaluacion;

public interface IEvaluacionService extends ICRUD<Evaluacion> {
	
	Evaluacion registrarTransaccional(EvaluacionListaTestDTO dto);
	
	List<Evaluacion> buscar(FiltroEvaluacionDTO filtro);
	
	List<Evaluacion> buscarFecha(FiltroEvaluacionDTO filtro);
	
	List<EvaluacionResumenDTO> listarResumen();
	
	byte[] generarReporte();
}
