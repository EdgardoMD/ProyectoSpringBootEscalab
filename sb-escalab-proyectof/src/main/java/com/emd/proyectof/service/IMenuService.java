package com.emd.proyectof.service;

import java.util.List;

import com.emd.proyectof.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
