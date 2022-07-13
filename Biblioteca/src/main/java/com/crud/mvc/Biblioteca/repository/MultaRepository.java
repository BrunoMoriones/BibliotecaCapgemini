package com.crud.mvc.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.mvc.Biblioteca.model.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long>{

}
