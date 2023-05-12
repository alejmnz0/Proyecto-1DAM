package com.salesianostriana.dam.cinejava;

import java.time.LocalDate;
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
		
		Usuario admin = Usuario.builder()
				.admin(true)
				.password("{bcrypt}$2a$12$GsUXFobMZAxzGeKkOXAXe.SebrjbNvsTAUIWlOTCsd5j8rQ/k4TYu")
				.email("admin@admin.es")
				.nombre("Alejandro")
				.apellidos("Jiménez")
				.fechaNac(LocalDate.of(2004,06,11))
				.build();
		
		Usuario usuario = Usuario.builder()
				.admin(false)
				//.password("1234")
				.email("user@user.es")
				.password(passwordEncoder.encode("1234"))
				.nombre("Antonio")
				.apellidos("García")
				.fechaNac(LocalDate.of(2004,01,16))
				.build();
		
		repo.saveAll(List.of(admin, usuario));
		
	}

}
