package com.crud.mvc.Biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.mvc.Biblioteca.model.Multa;
import com.crud.mvc.Biblioteca.service.MultaService;

@Controller
public class MultaController {

	@Autowired
	private MultaService multaService;
	
	@GetMapping("/addMulta")
	public String showNewMultaForm(Model model) {
		Multa multa = new Multa();
		model.addAttribute("multa", multa);
		return "new_multa";
	}
	
	@PostMapping("/saveMulta")
	public String saveMulta(@ModelAttribute("multa") Multa multa) {
		multaService.saveMulta(multa);
		return "redirect:/";
	}
	
	@GetMapping("/updateMulta/{id}")
	public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

		Multa multa = multaService.getMultaById(id);
		model.addAttribute("multa", multa);
		return "update_multa";
	}

	@GetMapping("/deleteMulta/{id}")
	public String deleteMulta(@PathVariable (value = "id") long id) {

		this.multaService.deleteMultaById(id);
		return "redirect:/";
	}
}
