package com.salesianostriana.dam.cinejava.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Asiento;
import com.salesianostriana.dam.cinejava.model.AsientoId;
import com.salesianostriana.dam.cinejava.model.Pase;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Sala;
import com.salesianostriana.dam.cinejava.repository.SalaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaService extends BaseServiceImpl<Sala, Long, SalaRepository>{

	private final SalaRepository repoSalas ;
	
	/***
	 * Crea los asientos de la sala y genera 
	 * 3 pases al dia (uno cada 3 horas a partir
	 * de la hora de apertura) para una semana
	 * al crear una nueva sala.)
	 * @param s
	 * @return
	 */
	
	
	public Sala add (Sala s) {
		byte semana=7;
		byte filas=8;
		byte columnas=7;
		LocalTime horaApertura= LocalTime.of(15, 00);
		LocalDate dia = LocalDate.now();
		
		
		for (int i = 1; i < filas; i++) {
			for (int j = 1; j < columnas; j++) {
				Asiento a = (i<filas-1)?new Asiento(new AsientoId (i,j,s.getId()) ,s,false):new Asiento(new AsientoId (i,j,s.getId()) ,s,true);
				s.addAsiento(a);
			}
		}
		
		for (int i = 1; i < semana; i++) {
			for (int j = 0; j < 7; j+=3) {
				Pase p = Pase.builder()
				.sala(s)
				.fecha(LocalDateTime.of(dia.plusDays(i), horaApertura.plusHours(j)))
				.build();
				s.addPase(p);
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
	
	public List<Pase> findPaseByFilm(Pelicula p) {
		return this.repository.buscarPasePorPeli(p);
	}
	
	public Pase findPaseById(long id) {
		return this.repository.buscarPasePorId(id);
	}
	
	public List<Asiento> findAsientosByPase(long id) {
		return this.repository.findAsientosByPaseId(id);
	}
	
}
