package com.crud.mvc.Biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.mvc.Biblioteca.model.Lector;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long>{

}
