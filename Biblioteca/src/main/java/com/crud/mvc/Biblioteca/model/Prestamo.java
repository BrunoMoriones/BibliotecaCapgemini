package com.crud.mvc.Biblioteca.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prestamos")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private LocalDate inicio;
	@Column
	private LocalDate fin;
	@ManyToOne
	@JoinColumn(name = "nSocio") // referencedColumnName = "nSocio", columnDefinition = "long")
	private Lector lector;
	@OneToOne
	@JoinColumn(name = "idLibro") //referencedColumnName = "id", columnDefinition = "long")
	private Libro libro;

	public Prestamo() {
	}

	public Prestamo(Long id, LocalDate inicio, LocalDate fin, Lector lector, Libro libro) {
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.lector = lector;
		this.libro = libro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
