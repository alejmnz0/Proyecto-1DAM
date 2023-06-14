package com.salesianostriana.dam.cinejava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cinejava.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

	@Query("SELECT e FROM Entrada e WHERE pase_id_pase = :idPase AND asiento_id = :idAsiento")
	public Optional<Entrada> findEntradaByIdAsientoAndIdPase(long idAsiento, long idPase);
	
	@Query("SELECT e FROM Entrada e WHERE pase_id_pase = :idPase")
	public List<Entrada> findEntradaByIdPase(long idPase);
	
	
}
