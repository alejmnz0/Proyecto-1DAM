package com.salesianostriana.dam.cinejava.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeliculaService {

	private final PeliculaRepository repositorioPelis;
	
	private Pelicula add (Pelicula p) {
		return repositorioPelis.save(p);
	}
}
