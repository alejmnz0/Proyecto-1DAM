package com.salesianostriana.dam.cinejava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Pase;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;
import com.salesianostriana.dam.cinejava.repository.SalaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeliculaService extends BaseServiceImpl<Pelicula, Long, PeliculaRepository> {

	private final PeliculaRepository repositorioPelis;
	private final SalaRepository repositorioSalas;

	public Pelicula add(Pelicula p) {
		byte breakPoint = 0;

		for (Sala sala : repositorioSalas.findAll()) {
			for (Pase pase : sala.getPases()) {
				if (pase.getPeli() == null && breakPoint < 9) {
					pase.setPeli(p);
					breakPoint++;
				}
			}
		}

		return repositorioPelis.save(p);
	}
}
