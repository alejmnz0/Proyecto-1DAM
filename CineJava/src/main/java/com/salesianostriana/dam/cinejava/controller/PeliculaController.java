package com.salesianostriana.dam.cinejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cinejava.service.PeliculaService;

@Controller
@RequestMapping("/admin/peliculas")
public class PeliculaController {

	@Autowired
	private PeliculaService servicioPeli;
	
	@GetMapping({"/", "/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioPeli.findAll());
		return "pelis";
	}
}
