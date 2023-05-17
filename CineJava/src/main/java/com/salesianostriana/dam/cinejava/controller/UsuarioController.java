package com.salesianostriana.dam.cinejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Autowired
	private UsuarioService servicioUsuario;
	
	@GetMapping("/login") 
	public String mandarLogin () {
		return "login";
	}
	
	
	@GetMapping("/me")
	public String me() {

		Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		System.out.println(u.toString());

		return "index";
	}

	@GetMapping("/me2")
	public String me2(@AuthenticationPrincipal Usuario u) {

		System.out.println(u.toString());

		return "index";
	}
	
	@GetMapping("/register")
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "userRegister";
	}
	
	@PostMapping("/register/submit")
	public String procesarRegistro (@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.add(u);
		return "redirect:/login/";
	}
	
	@GetMapping("/información")
	public String mostrarAboutUs () {
		return "info";
	}
	
	@GetMapping("/información/salas")
	public String mostrarInfoSalas () {
		return "infosalas";
	}
	
}
