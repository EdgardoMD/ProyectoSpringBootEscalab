package com.emd.proyectof.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emd.proyectof.dto.EvaluacionListaTestDTO;
import com.emd.proyectof.dto.EvaluacionResumenDTO;
import com.emd.proyectof.dto.FiltroEvaluacionDTO;
import com.emd.proyectof.model.Evaluacion;
import com.emd.proyectof.repo.IEvaluacionRepo;
import com.emd.proyectof.repo.IEvaluacionTestRepo;
import com.emd.proyectof.service.IEvaluacionService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EvaluacionServiceImpl implements IEvaluacionService{

	@Autowired
	private IEvaluacionRepo repo;
	@Autowired
	private IEvaluacionTestRepo etRepo;
	
	@Override
	public Evaluacion registrar(Evaluacion evaluacion) {
		
		return repo.save(evaluacion);
	}

	@Override
	public Evaluacion modificar(Evaluacion evaluacion) {
		
		return repo.save(evaluacion);
	}

	@Override
	public List<Evaluacion> listar() {
		
		return repo.findAll();
	}

	@Override
	public Evaluacion leerPorId(Integer id) {
		Optional<Evaluacion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Evaluacion();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Transactional
	@Override
	public Evaluacion registrarTransaccional(EvaluacionListaTestDTO dto) {
		dto.getEvaluacion().getDetalleEvaluacion().forEach(det ->{
			det.setEvaluacion(dto.getEvaluacion());
		});
		repo.save(dto.getEvaluacion());
		dto.getListaTest().forEach(ex -> etRepo.registrar(dto.getEvaluacion().getIdEvaluacion(), ex.getIdTest()));
		return dto.getEvaluacion();
	}

	@Override
	public List<Evaluacion> buscar(FiltroEvaluacionDTO filtro) {
		
		return repo.buscar(filtro.getRun(), filtro.getNombreCompleto());
	}

	@Override
	public List<EvaluacionResumenDTO> listarResumen() {
		List<EvaluacionResumenDTO> evaluaciones = new ArrayList<>();
		
		repo.listarResumen().forEach(x ->{
			EvaluacionResumenDTO er = new EvaluacionResumenDTO();
			er.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			er.setFecha(String.valueOf(x[1]));
			evaluaciones.add(er);
		});
		
		return evaluaciones;
	}

	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/evaluaciones.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Evaluacion> buscarFecha(FiltroEvaluacionDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaEvaluacion().plusDays(1);
		return repo.buscarFecha(filtro.getFechaEvaluacion(), fechaSgte);
	}

}
