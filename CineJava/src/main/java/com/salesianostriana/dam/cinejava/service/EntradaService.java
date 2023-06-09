package com.salesianostriana.dam.cinejava.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Entrada;
import com.salesianostriana.dam.cinejava.repository.EntradaRepository;

@Service
public class EntradaService extends BaseServiceImpl<Entrada, Long, EntradaRepository> {

	public Optional<Entrada> findEntradaVendida(long idAsiento, long idPase) {
		return this.repository.findEntradaByIdAsientoAndIdPase(idAsiento, idPase);
	}
	
}
