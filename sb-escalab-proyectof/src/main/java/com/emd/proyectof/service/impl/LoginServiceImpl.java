package com.emd.proyectof.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emd.proyectof.model.Usuario;
import com.emd.proyectof.repo.ILoginRepo;
import com.emd.proyectof.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private ILoginRepo repo;

	@Override
	public Usuario verificarNombreUsuario(String usuario) throws Exception {
		
		Usuario us = null;
		try {
			us = repo.verificarNombreUsuario(usuario);
			us = us != null ? us : new Usuario();
		}catch (Exception e) {
			us = new Usuario();
		}
		return us;
	}

	@Override
	public int cambiarClave(String clave, String nombre) throws Exception {
		
		int rpta = 0;
		try {
			repo.cambiarClave(clave, nombre);
			rpta = 1;
		} catch (Exception e) {
			rpta = 0;
		}
		return rpta;
	}
}