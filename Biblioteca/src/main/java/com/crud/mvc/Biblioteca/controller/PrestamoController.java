package com.crud.mvc.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.mvc.Biblioteca.model.Join;
import com.crud.mvc.Biblioteca.model.Prestamo;
import com.crud.mvc.Biblioteca.service.LibroService;
import com.crud.mvc.Biblioteca.service.PrestamoService;

@Controller
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping("/getAllPrestamos")
	public List<Prestamo> getAllPrestamos(){
		return prestamoService.getAllPrestamos();
	}
	
	@GetMapping("/prestamo")
	public String viewHomePage(Model model) {
		return findPaginated(1, "id","asc",model);
	}
	
	@GetMapping("/addPrestamo")
	public String showNewLibroForm(Model model) {
		//Prestamo prestamo = new Prestamo();
		Join join = new Join();
		model.addAttribute("prestamo", join);
		return "new_prestamo";
	}
	
	@PostMapping("/savePrestamo")
	public String savePrestamo2(@ModelAttribute Join join) {
		this.prestamoService.addPrestamo(join.getIdLibro(), join.getNSocio());
		return "redirect:/prestamos";
	}
	
	@GetMapping("/updatePrestamo/{id}")
	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
		Prestamo prestamo = prestamoService.getPrestamoById(id);
		model.addAttribute("prestamo", prestamo);
		return "update_prestamos";
	}

	@GetMapping("/devolverPrestamo/{id}")
	public String deletePrestamo(@PathVariable (value = "id") long id) {
		this.prestamoService.deletePrestamoById(id);
		return "redirect:/prestamos";
	}
	
	@GetMapping("/prestamos")
	public String pagePrestamos(Model model) {
		this.findPaginated(1, "fin","asc",model);
		return "prestamos";
	}
	
	@GetMapping("/pagePrestamo/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) { 
		int pageSize = 5;

		Page<Prestamo> page = prestamoService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Prestamo> listPrestamos = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPrestamos", listPrestamos);
		return "prestamo";
	}
}
