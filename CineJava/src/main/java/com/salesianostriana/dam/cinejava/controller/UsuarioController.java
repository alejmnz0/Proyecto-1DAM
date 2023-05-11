package com.salesianostriana.dam.cinejava.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.cinejava.model.Usuario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UsuarioController {
	
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
	
}
