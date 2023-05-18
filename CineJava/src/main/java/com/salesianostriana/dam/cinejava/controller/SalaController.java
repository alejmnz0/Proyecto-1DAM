package com.salesianostriana.dam.cinejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.service.SalaService;

@Controller
@RequestMapping("/admin/salas")
public class SalaController {

	@Autowired
	private SalaService servicioSala;
	
	@GetMapping({"/", "/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioSala.findAll());
		return "salas";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") int id, Model model) {

		Sala aEditar = servicioSala.findById(id);

		if (aEditar != null) {
			model.addAttribute("sala", aEditar);
			return "salaRegister";
		} else {
			return "redirect:/admin/salas/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("sala") Sala a) {
		servicioSala.edit(a);
		return "redirect:/admin/salas/";
	}
	
	@PostMapping("/nuevo")
	public String addSala(@ModelAttribute("sala") Sala s,  Model model) {
		servicioSala.add(s);
		return "redirect:/admin/salas";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") int id) {
		servicioSala.delete(id);
		return "redirect:/admin/salas/";
	}
}