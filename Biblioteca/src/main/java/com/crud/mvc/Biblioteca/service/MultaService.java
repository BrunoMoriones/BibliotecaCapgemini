package com.crud.mvc.Biblioteca.service;

import java.util.List;

import com.crud.mvc.Biblioteca.model.Multa;

public interface MultaService {

	List<Multa> getAllMultas();

	void saveMulta(Multa multa);

	Multa getMultaById(long id);
	
	void deleteMultaById(long id);
}
