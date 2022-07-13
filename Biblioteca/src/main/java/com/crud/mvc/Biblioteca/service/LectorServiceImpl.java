package com.crud.mvc.Biblioteca.service;

import java.time.LocalDate;
import java.util.Date;
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

@Service
public class LectorServiceImpl implements LectorService {

	@Autowired
	private LectorRepository lectorRepository;

	@Override
	public List<Lector> getAllLectores() {
		return lectorRepository.findAll();
	}

	@Override
	public void saveLector(Lector lector) {
		this.lectorRepository.save(lector);
	}

	@Override
	public Lector getLectorById(long nSocio) {
		Optional<Lector> optionalLector = lectorRepository.findById(nSocio);
		Lector lector = null;
		if (optionalLector.isPresent()) {
			lector = optionalLector.get();
		} else {
			throw new RuntimeException("No se ha encontrado el lector con NroSocio: " + nSocio);
		}
		return lector;
	}

	@Override
	public void deleteLectorById(long id) {
		this.lectorRepository.deleteById(id);
	}

	@Override
	public void devolver(Long id, Date fechaAct) {

	}

	@Override
	public void prestar(Long id, LocalDate fechaAct) {
		//Agrega el prestamo desde PrestamoServiceImpl
	}

	@Override
	public void multar(int dias) {

	}

	@Override
	public Page<Lector> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
		return this.lectorRepository.findAll(pageable);
	}
}
