package com.emd.proyectof.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emd.proyectof.model.ResetToken;



public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}

