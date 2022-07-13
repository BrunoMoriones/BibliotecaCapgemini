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

import com.crud.mvc.Biblioteca.model.Libro;
import com.crud.mvc.Biblioteca.service.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping
	public List<Libro> getAllLibros() {
		return libroService.getAllLibros();
	}

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "titulo", "asc", model);
	}

	@GetMapping("/addLibro")
	public String showNewLibroForm(Model model) {
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		return "new_libro";
	}

	@PostMapping("/saveLibro")
	public String saveLibro(@ModelAttribute("libro") Libro libro) {
		// save Libro to database
		libroService.saveLibro(libro);
		return "redirect:/";
	}

	@GetMapping("/updateLibro/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Libro libro = libroService.getLibroById(id);
		model.addAttribute("libro", libro);
		return "update_libro";
	}

	@GetMapping("/deleteLibro/{id}")
	public String deleteLibro(@PathVariable(value = "id") long id) {

		this.libroService.deleteLibroById(id);
		return "redirect:/";
	}
	
	@GetMapping("/index")
	public String pageIndex() {
		return "redirect:/";
	}

	@GetMapping("/lendLibro/{id}")
	public String lendLibro() {
		return "lend_libro";
	}

	@GetMapping("/page/{pageNo}") 
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) { 
		int pageSize = 5;

		Page<Libro> page = libroService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Libro> listLibros = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listLibros", listLibros);
		return "index";
	}

}
