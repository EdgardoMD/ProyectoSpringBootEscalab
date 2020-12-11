package com.emd.proyectof.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emd.proyectof.model.Test;

public interface ITestRepo extends JpaRepository<Test, Integer> {

}
