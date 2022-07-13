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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.mvc.Biblioteca.model.Lector;
import com.crud.mvc.Biblioteca.service.LectorService;

@Controller
public class LectorController {

	@Autowired
	private LectorService lectorService;
	
	@GetMapping("/getAllLibros")
	public List<Lector> getAllLectores(){
		return lectorService.getAllLectores();
	}
	
	@GetMapping("/lector")
	public String viewHomePage(Model model) {
		return findPaginated(1, "nombre","asc",model);
	}
	
	@GetMapping(path = "/{id}")
	public Lector getById(@PathVariable(value = "id") long id) {
		return lectorService.getLectorById(id);
	}
	
	@GetMapping("/lectores")
	public String pageLectores(Model model) {
		this.findPaginated(1, "nombre","asc",model);
		return "lectores";
	}
	
	@GetMapping("/deleteLector/{id}")
	public String deleteLector(@PathVariable (value = "id") long id) {
		this.lectorService.deleteLectorById(id);
		return "redirect:/lector";
	}
	
	@GetMapping("/addLector")
	public String showNewLectorForm(Model model) {
		Lector lector = new Lector();
		model.addAttribute("lector", lector);
		return "new_lector";
	}
	
	@PostMapping("/saveLector")
	public String saveLector(@ModelAttribute("lector") Lector lector) {
		lectorService.saveLector(lector);
		return "redirect:/lector";
	}
	
	@GetMapping("/updateLector/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Lector lector = lectorService.getLectorById(id);
		model.addAttribute("lector", lector);
		return "update_lector";
	}
	
	@GetMapping("/pageLector/{pageNo}") 
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) { 
		int pageSize = 5;

		Page<Lector> page = lectorService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Lector> listLectores = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLectores", listLectores);
		return "lectores";
	}
}
