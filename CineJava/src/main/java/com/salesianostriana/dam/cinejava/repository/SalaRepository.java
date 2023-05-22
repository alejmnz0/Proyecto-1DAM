package com.salesianostriana.dam.cinejava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cinejava.model.Asiento;
import com.salesianostriana.dam.cinejava.model.Pase;
import com.salesianostriana.dam.cinejava.model.Pelicula;
import com.salesianostriana.dam.cinejava.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

	@Query("""
				select a
				from Pase a
				where a.peli = :p
			""")
	List<Pase> buscarPasePorPeli(Pelicula p);

	@Query("""
				select a
				from Pase a
				where a.id_pase = :id
			""")
	Pase buscarPasePorId(long id);

	@Query("""
				select a.asientos
				from Sala a
				where a.pases = :pa
			""")
	List<Asiento> buscarAsientosPorPase(Pase pa);
}