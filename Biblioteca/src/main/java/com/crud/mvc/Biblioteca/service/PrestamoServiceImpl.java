package com.crud.mvc.Biblioteca.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.mvc.Biblioteca.model.Lector;
import com.crud.mvc.Biblioteca.model.Libro;
import com.crud.mvc.Biblioteca.model.Prestamo;
import com.crud.mvc.Biblioteca.repository.LectorRepository;
import com.crud.mvc.Biblioteca.repository.LibroRepository;
import com.crud.mvc.Biblioteca.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService {

	@Autowired
	private PrestamoRepository prestamoRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	private LectorRepository lectorRepository;
	
	@Override
	public void addPrestamo(String idLibro, String nSocio) {
		
		long nSocioAux = Long.parseLong(nSocio);
		long idLibroAux = Long.parseLong(idLibro);
		
		Libro libro = libroRepository.findById(idLibroAux).get();
		Lector lector = lectorRepository.findById(nSocioAux).get();
	
		
		Prestamo prestamo = new Prestamo();
		prestamo.setLector(lector);
		prestamo.setLibro(libro);
		prestamo.setInicio(LocalDate.now());
		prestamo.setFin(LocalDate.now().plusDays(30));
		
		Lector lectorAux = new Lector();
		lectorAux = lector;
		lectorAux.setPrestamos(lector.getPrestamos());
		lectorRepository.save(lectorAux);
		prestamoRepository.save(prestamo);
	}
	

	@Override
	public List<Prestamo> getAllPrestamos() {
		return prestamoRepository.findAll();
	}

	@Override
	public void savePrestamo(Prestamo prestamo) {
		this.prestamoRepository.save(prestamo);
	}

	@Override
	public Prestamo getPrestamoById(long id) {
		Optional<Prestamo> optionalPrestamo = prestamoRepository.findById(id);
		Prestamo prestamo = null;
		if (optionalPrestamo.isPresent()) {
			prestamo = optionalPrestamo.get();
		} else {
			throw new RuntimeException("No se ha encontrado el prestamo con id: " + id);
		}
		return prestamo;
	}

	@Override
	public void deletePrestamoById(long id) {
		this.prestamoRepository.deleteById(id);
	}

	@Override
	public Page<Prestamo> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.prestamoRepository.findAll(pageable);
	}

}
