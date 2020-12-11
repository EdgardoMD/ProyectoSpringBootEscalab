package com.emd.proyectof.service;

import com.emd.proyectof.model.Archivo;

public interface IArchivoService {
	
	int guardar(Archivo archivo);
	byte[] leerArchivo(Integer idArchivo);

}
