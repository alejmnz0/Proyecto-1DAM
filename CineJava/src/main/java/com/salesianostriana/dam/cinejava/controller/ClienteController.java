package com.salesianostriana.dam.cinejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.cinejava.model.Cliente;
import com.salesianostriana.dam.cinejava.service.ClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ClienteController {

	private ClienteService servicioCliente;
	
	@GetMapping({"/", "/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista", servicioCliente.findAll());
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String mostrarRegistro (Model model) {
		model.addAttribute("cliente", new Cliente());
		return "register";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarRegistro (@ModelAttribute("cliente") Cliente c) {
		servicioCliente.add(c);
		return "redirect:/list";
	}
	
	@GetMapping("/login") 
	public String mandarLogin () {
		return "login";
	}
	
}
