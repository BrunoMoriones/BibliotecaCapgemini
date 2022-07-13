package com.crud.mvc.Biblioteca.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lectores")
public class Lector {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long nSocio;
	@Column
	private String nombre;
	@Column
	private String telefono;
	@Column
	private String direccion;
	
	@OneToMany(mappedBy="lector", cascade = CascadeType.PERSIST) //targetEntity=Prestamo.class
	private List<Prestamo> prestamos;

	public Lector() {}
	
	public Lector(Long nSocio, String nombre, String telefono, String direccion) {
		this.nSocio = nSocio;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	public Long getNSocio() {
		return nSocio;
	}
	public void setNSocio(Long nSocio) {
		this.nSocio = nSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
}
