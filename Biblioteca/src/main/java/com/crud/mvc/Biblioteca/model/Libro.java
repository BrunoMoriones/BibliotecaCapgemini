package com.crud.mvc.Biblioteca.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="libros")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String titulo;
	@Column
	private String tipo;
	@Column
	private String editorial;
	@Column
	private int anyo;
	@Column(name = "autor")
	private String nombreAutor;
	@Column(name = "nacionalidad_autor")
	private String nacionalidadAutor;
	@Column(name = "nacimiento_autor")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaNacAutor;

	public Libro() {}
	
	public Libro(Long id, String titulo, String editorial, int anyo, String nombreAutor, String nacionalidadAutor,
			LocalDate fechaNacAutor) {
		this.id = id;
		this.titulo = titulo;
		this.editorial = editorial;
		this.anyo = anyo;
		this.nombreAutor = nombreAutor;
		this.nacionalidadAutor = nacionalidadAutor;
		this.fechaNacAutor = fechaNacAutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getNombreAutor() {
		return nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNacionalidadAutor() {
		return nacionalidadAutor;
	}

	public void setNacionalidadAutor(String nacionalidadAutor) {
		this.nacionalidadAutor = nacionalidadAutor;
	}

	public LocalDate getFechaNacAutor() {
		return fechaNacAutor;
	}

	public void setFechaNacAutor(LocalDate fechaNacimientoAutor) {
		this.fechaNacAutor = fechaNacimientoAutor;
	}
}
