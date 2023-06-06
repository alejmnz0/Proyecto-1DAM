package com.salesianostriana.dam.cinejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.cinejava.model.Ajustes;

public interface AjustesRepository extends JpaRepository<Ajustes, Integer>{

	@Query("""
			select a.precioBaseEntrada
			from Ajustes a
			where a.id = :id
		""")
	double findPrecioBaseEntradaById(int id);
	
	@Query("""
			select a.precioVip
			from Ajustes a
			where a.id = :id
		""")
	double findPrecioVipById(int id);
	
	@Query("""
			select a.diaDescuento
			from Ajustes a
			where a.id = :id
		""")
	String findDiaDescuentoById(int id);
	
	@Query("""
			select a.porcentDescuento
			from Ajustes a
			where a.id = :id
		""")
	double findPorcentDescuentoById(int id);
	
	@Query("""
			select a.cantEntradasParaGratis
			from Ajustes a
			where a.id = :id
		""")
	double findCantEntradasParaGratisById(int id);
}
