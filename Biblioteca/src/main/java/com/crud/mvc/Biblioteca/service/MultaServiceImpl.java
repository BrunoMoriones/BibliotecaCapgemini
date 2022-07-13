package com.crud.mvc.Biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.mvc.Biblioteca.model.Multa;
import com.crud.mvc.Biblioteca.repository.MultaRepository;

@Service
public class MultaServiceImpl implements MultaService{

	@Autowired
	private MultaRepository multaRepository;
	
	@Override
	public List<Multa> getAllMultas() {
		return multaRepository.findAll();
	}

	@Override
	public void saveMulta(Multa multa) {
		this.multaRepository.save(multa);
	}

	@Override
	public Multa getMultaById(long id) {
		Optional<Multa> optionalMulta = multaRepository.findById(id);
		Multa multa = null;
		if(optionalMulta.isPresent()) {
			multa = optionalMulta.get();
		} else {
			throw new RuntimeException("No se ha encontrado la multa con id: " + id);
		}
		return multa;
	}

	@Override
	public void deleteMultaById(long id) {
		this.multaRepository.deleteById(id);
	}

}
