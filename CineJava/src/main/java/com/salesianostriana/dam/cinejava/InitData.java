package com.salesianostriana.dam.cinejava;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;
import com.salesianostriana.dam.cinejava.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {
	
	private final UsuarioRepository repo;
	private final PeliculaRepository repopelis;
	private final PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		
//		Usuario admin = Usuario.builder()
//				.admin(true)
//				.password("{bcrypt}$2a$12$GsUXFobMZAxzGeKkOXAXe.SebrjbNvsTAUIWlOTCsd5j8rQ/k4TYu")
//				.email("admin@admin.es")
//				.nombre("Alejandro")
//				.apellidos("Jiménez")
//				.fechaNac(LocalDate.of(2004,06,11))
//				.build();
//		
//		Usuario usuario = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario2 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario3 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario4 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario5 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario6 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario7 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario8 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario9 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario10 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		Usuario usuario11 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		Usuario usuario12 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		Usuario usuario13 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		Usuario usuario14 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		Usuario usuario15 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		Usuario usuario16 = Usuario.builder()
//				.admin(false)
//				//.password("1234")
//				.email("user@user.es")
//				.password(passwordEncoder.encode("1234"))
//				.nombre("Antonio")
//				.apellidos("García")
//				.fechaNac(LocalDate.of(2004,01,16))
//				.build();
//		
//		
//		
//		
//		repo.saveAll(List.of(admin, usuario, usuario2, usuario3, usuario4, usuario5
//				, usuario6, usuario7, usuario8, usuario9, usuario10, usuario11, usuario12
//				, usuario13, usuario14, usuario15, usuario16));
		
		Pelicula peli1 = Pelicula.builder()
				.titulo("Los vengadores")
				.portada("https://www.cinemascomics.com/wp-content/uploads/2019/03/poster-vengadores-endgame.jpg.webp")
				.sinopsis("to golfos los vengadores")
				.altPortada("portada de los vengadores")
				.build();
		
		repopelis.save(peli1);
	}

}
