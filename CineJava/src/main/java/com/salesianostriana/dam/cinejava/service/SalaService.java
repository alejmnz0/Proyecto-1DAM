package com.salesianostriana.dam.cinejava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.repository.SalaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaService {

	private final SalaRepository repoSalas;
	
	public Sala add (Sala s) {
		return repoSalas.save(s);
	}
	
	public Sala edit (Sala s) {
		return repoSalas.save(s);
	}
	
	public void delete (Sala s) {
		repoSalas.delete(s);
	}
	
	public void delete (Integer id) {
		repoSalas.deleteById(id);
	}
	
	public List<Sala> findAll () {
		return repoSalas.findAll();
	}
	
	public Sala findById (Integer id) {
		return repoSalas.findById(id).orElse(null);
	}
}
