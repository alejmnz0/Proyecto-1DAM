//package com.salesianostriana.dam.cinejava;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.stereotype.Component;
//
//import com.salesianostriana.dam.cinejava.model.Pelicula;
//import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class InitData {
//	
//	private final PeliculaRepository repopelis;
//	
//	@PostConstruct
//	public void init() {
//		
//		Pelicula peli1 = Pelicula.builder()
//				.titulo("Los vengadores")
//				.portada("https://www.cinemascomics.com/wp-content/uploads/2019/03/poster-vengadores-endgame.jpg.webp")
//				.sinopsis("to golfos los vengadores")
//				.altPortada("portada de los vengadores")
//				.build();
//		
//		repopelis.save(peli1);
//	}
//
//}
