package com.salesianostriana.dam.cinejava.controller;

import java.util.Optional;

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

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioSala.findAll());
		return "salas";
	}

	@GetMapping("/nuevo")
	public String mostrarRegistro(Model model) {
		model.addAttribute("sala", new Sala());
		return "salaRegister";
	}

	@PostMapping("/nuevo/submit")
	public String procesarRegistro(@ModelAttribute("sala") Sala s) {
		servicioSala.add(s);
		return "redirect:/admin/salas/";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Optional<Sala> aEditar = servicioSala.findById(id);

		if (aEditar.isPresent()) {
			model.addAttribute("sala", aEditar.get());
			return "salaRegister";
		} else {
			return "redirect:/admin/salas/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pelicula") Sala s) {
		servicioSala.edit(s);
		return "redirect:/admin/salas/";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		return (servicioSala.deleteSala(servicioSala.findById(id).get()))? "redirect:/admin/salas/":"/admin/salas/?error=true";
	}
}