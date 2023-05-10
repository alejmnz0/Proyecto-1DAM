package com.salesianostriana.dam.cinejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.service.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UsuarioController {

	private UsuarioService servicioUsuario;
	
	@GetMapping({"/", "/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioUsuario.findAll());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String mostrarRegistro (Model model) {
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarRegistro (@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.add(u);
		return "redirect:/list";
	}
	
	@GetMapping("/login") 
	public String mandarLogin () {
		return "login";
	}
	
}
