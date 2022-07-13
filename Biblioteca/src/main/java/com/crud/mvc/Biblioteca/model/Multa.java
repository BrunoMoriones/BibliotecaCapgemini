package com.crud.mvc.Biblioteca.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="multas")
public class Multa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date fInicio;
	@Column
	private Date fFin;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nSocio")
	private Lector lector;
	
	public Multa() {}

	public Multa(Long id, Date fInicio, Date fFin, Lector lector) {
		this.id = id;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.lector = lector;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public Lector getLector() {
		return lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
	}
	
	
}
