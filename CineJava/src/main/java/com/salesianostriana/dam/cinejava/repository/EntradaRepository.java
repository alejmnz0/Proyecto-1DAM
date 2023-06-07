package com.salesianostriana.dam.cinejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cinejava.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, Long> {

	@Query("SELECT e FROM Entrada e JOIN e.pase p JOIN e.asiento a  WHERE p.id_pase = :idPase AND a.id = :idAsiento")
	public Entrada findEntradaByIdAsientoAndIdPase(long idAsiento, long idPase);
	
	
}
