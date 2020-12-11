package com.emd.proyectof.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emd.proyectof.model.EvaluacionTest;

public interface IEvaluacionTestRepo extends JpaRepository<EvaluacionTest, Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO evaluacion_test(id_evaluacion, id_test) VALUES (:idEvaluacion, :idTest)", nativeQuery = true)
	Integer registrar(@Param("idEvaluacion") Integer idEvaluacion, @Param("idTest") Integer idTest);
	
	@Query("from EvaluacionTest et where et.evaluacion.idEvaluacion = :idEvaluacion")
	List<EvaluacionTest> listarTestsPorEvaluacion(@Param("idEvaluacion") Integer idEvaluacion);

}
