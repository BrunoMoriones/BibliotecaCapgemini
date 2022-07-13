package com.crud.mvc.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.mvc.Biblioteca.model.Lector;
import com.crud.mvc.Biblioteca.model.Libro;
import com.crud.mvc.Biblioteca.model.Prestamo;

public interface PrestamoService {

	List<Prestamo> getAllPrestamos();
	
	void addPrestamo(String idLibro, String nSocio);

	void savePrestamo(Prestamo prestamo);

	Prestamo getPrestamoById(long id);
	
	void deletePrestamoById(long id);

	Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
