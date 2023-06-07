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

import com.salesianostriana.dam.cinejava.model.Ajustes;
import com.salesianostriana.dam.cinejava.service.AjustesService;

@Controller
@RequestMapping("/admin/config")
public class AjustesController {

	@Autowired
	private AjustesService servicioAjustes;

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioAjustes.findAll());
		return "config";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") int id, Model model) {

		Optional<Ajustes> aEditar = servicioAjustes.findById(id);

		if (aEditar.isPresent()) {
			model.addAttribute("ajustes", aEditar.get());
			return "configForm";
		} else {
			return "redirect:/admin/config/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("ajustes") Ajustes a) {
		servicioAjustes.edit(a);
		return "redirect:/admin/config/";
	}
}