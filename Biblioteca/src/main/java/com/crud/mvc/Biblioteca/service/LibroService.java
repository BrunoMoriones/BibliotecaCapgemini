package com.crud.mvc.Biblioteca.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.mvc.Biblioteca.model.Libro;

public interface LibroService {

	List<Libro> getAllLibros();

	void saveLibro(Libro libro);

	Libro getLibroById(long id);
	
	void deleteLibroById(long id);

	Page<Libro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
