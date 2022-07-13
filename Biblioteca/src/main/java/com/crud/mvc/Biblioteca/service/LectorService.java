package com.crud.mvc.Biblioteca.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.mvc.Biblioteca.model.Lector;
import com.crud.mvc.Biblioteca.model.Libro;

public interface LectorService {

	List<Lector> getAllLectores();

	void saveLector(Lector lector);

	Lector getLectorById(long id);

	void deleteLectorById(long id);
	
	Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);

	public void devolver(Long id, Date fechaAct);

	public void prestar(Long id, LocalDate fechaAct);
	
	public void multar(int dias);
}
