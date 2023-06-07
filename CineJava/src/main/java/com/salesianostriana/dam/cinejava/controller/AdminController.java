package com.salesianostriana.dam.cinejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsuarioService servicioUsuario;

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioUsuario.findAll());
		return "users";
	}

	@GetMapping("/nuevo")
	public String mostrarRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "userRegister";
	}

	@PostMapping("/nuevo/submit")
	public String procesarRegistro(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.add(u);
		return "redirect:/admin/";
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioUsuario.delete(servicioUsuario.findById(id).get());
		return "redirect:/admin/";
	}
}
