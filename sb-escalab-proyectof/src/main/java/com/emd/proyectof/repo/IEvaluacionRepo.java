package com.emd.proyectof.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emd.proyectof.model.Evaluacion;

public interface IEvaluacionRepo extends JpaRepository<Evaluacion, Integer> {
	
	@Query("from Evaluacion e where e.alumno.run =:run or LOWER(e.alumno.nombres) like %:nombreCompleto% or LOWER(e.alumno.apellidos) like %:nombreCompleto%")
	List<Evaluacion> buscar(@Param("run")String run,@Param("nombreCompleto") String nombreCompleto);
	
	@Query("from Evaluacion e where e.fecha between :fechaEvaluacion and :fechaSgte")
	List<Evaluacion> buscarFecha(@Param("fechaEvaluacion") LocalDateTime fechaEvaluacion, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();
}
