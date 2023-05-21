package com.salesianostriana.dam.cinejava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Asiento;
import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.repository.SalaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaService {

	private final SalaRepository repoSalas;
	
	public Sala add (Sala s) {
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 9; j++) {
				Asiento a;
				if(i<7)
					a = new Asiento(i,j,s,false);
				else
					a = new Asiento(i,j,s,true);
				
				s.addAsiento(a);
			}
		}
		
		return repoSalas.save(s);
	}
	
	public Sala edit (Sala s) {
		return repoSalas.save(s);
	}
	
	public void delete (Sala s) {
		repoSalas.delete(s);
	}
	
	public void delete (long id) {
		repoSalas.deleteById(id);
	}
	
	public List<Sala> findAll () {
		return repoSalas.findAll();
	}
	
	public Sala findById (long id) {
		return repoSalas.findById(id).orElse(null);
	}
}
