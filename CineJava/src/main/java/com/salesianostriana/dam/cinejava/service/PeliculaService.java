package com.salesianostriana.dam.cinejava.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Pase;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.repository.PaseRepository;
import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeliculaService {

	private final PeliculaRepository repositorioPelis;
	private final PaseRepository repositorioPases;
	
	public Pelicula add (Pelicula p) {
		LocalDateTime fecha = LocalDateTime.now();
		Pase pa;
		for(Pase pase : repositorioPases.findAll()) {
			
		}
		
		for (Pase pase : repositorioPases.findAll()) {
			if(pase.getFecha().getDayOfYear()>(fecha.getDayOfYear()))
			fecha=pase.getFecha();
			
		}
		
		repositorioPases.save(pa);
		
		return repositorioPelis.save(p);
	}
	
	public Pelicula edit (Pelicula p) {
		return repositorioPelis.save(p);
	}
	
	public void delete (Pelicula p) {
		repositorioPelis.delete(p);
	}
	
	public void delete (long id) {
		repositorioPelis.deleteById(id);
	}
	
	public List<Pelicula> findAll () {
		return repositorioPelis.findAll();
	}
	
	public Pelicula findById (Long id) {
		return repositorioPelis.findById(id).orElse(null);
	}
}
