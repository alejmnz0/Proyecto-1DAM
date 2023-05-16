package com.salesianostriana.dam.cinejava.service;

import java.util.List;

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
	
	public List<Pelicula> findAll () {
		return repositorioPelis.findAll();
	}
	
	public Pelicula findById (Long id) {
		return repositorioPelis.findById(id).orElse(null);
	}
}
