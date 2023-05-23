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

import com.salesianostriana.dam.cinejava.model.Pelicula;
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
	
	@GetMapping("/nuevo")
	public String mostrarRegistro (Model model) {
		model.addAttribute("pelicula", new Pelicula());
		return "filmRegister";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarRegistro (@ModelAttribute("pelicula") Pelicula p) {
		servicioPeli.add(p);
		return "redirect:/admin/peliculas/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Optional<Pelicula> aEditar = servicioPeli.findById(id);

		if (aEditar.isPresent()) {
			model.addAttribute("pelicula", aEditar.get());
			return "filmRegister";
		} else {
			return "redirect:/admin/peliculas/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pelicula") Pelicula p) {
		servicioPeli.edit(p);
		return "redirect:/admin/peliculas/";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioPeli.delete(servicioPeli.findById(null).get());
		return "redirect:/admin/peliculas/";
	}
}
