package com.salesianostriana.dam.cinejava.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Entrada;
import com.salesianostriana.dam.cinejava.model.Pase;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.repository.EntradaRepository;
import com.salesianostriana.dam.cinejava.repository.PeliculaRepository;
import com.salesianostriana.dam.cinejava.repository.SalaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeliculaService extends BaseServiceImpl<Pelicula, Long, PeliculaRepository> {

	private final PeliculaRepository repositorioPelis;
	private final SalaRepository repositorioSalas;
	private final EntradaRepository repositorioEntradas;

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
	
	public boolean deletePeli(Pelicula p) {
		List<Entrada> entradas= new ArrayList<Entrada>();
		for (Pase pase : repositorioSalas.buscarPasePorPeli(p)) {
			if (!repositorioEntradas.findEntradaByIdPase(pase.getId_pase()).isEmpty()) {
				for (Entrada entrada : repositorioEntradas.findEntradaByIdPase(pase.getId_pase())) {
					entradas.add(entrada);
				}
			}
		}
		
		if (entradas.isEmpty()) {
			for (Pase pase : repositorioSalas.buscarPasePorPeli(p)) {
				pase.setPeli(null);
			}
			this.repository.delete(p);
			return true;
		}else
			return false;
	};
}
