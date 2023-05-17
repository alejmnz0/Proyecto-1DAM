package com.salesianostriana.dam.cinejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Usuario;
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
	public String procesarRegistro (@ModelAttribute("pelicula") Pelicula u) {
		servicioPeli.add(u);
		return "redirect:/admin/peliculas/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		Pelicula aEditar = servicioPeli.findById(id);

		if (aEditar != null) {
			model.addAttribute("pelicula", aEditar);
			return "filmRegister";
		} else {
			return "redirect:/admin/peliculas/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pelicula") Pelicula a) {
		servicioPeli.edit(a);
		return "redirect:/admin/peliculas/";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioPeli.delete(id);
		return "redirect:/admin/peliculas/";
	}
}
