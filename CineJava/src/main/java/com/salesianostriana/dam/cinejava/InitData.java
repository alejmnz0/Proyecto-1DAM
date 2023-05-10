package com.salesianostriana.dam.cinejava;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		
		Usuario usuario = Usuario.builder()
				.admin(false)
				//.password("1234")
				.email("user@user.es")
				.password(passwordEncoder.encode("1234"))
				.build();
		
		Usuario admin = Usuario.builder()
				.admin(true)
				.password(passwordEncoder.encode("admin"))
				.email("admin@admin.es")
				.build();
		
		repo.saveAll(List.of(usuario, admin));
		
	}

}
