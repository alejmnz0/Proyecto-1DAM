package com.salesianostriana.dam.cinejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cinejava.model.Ajustes;

public interface AjustesRepository extends JpaRepository<Ajustes, Integer>{

	double findPrecioBaseEntradaById(int id);
	double findPrecioVipById(int id);
}
