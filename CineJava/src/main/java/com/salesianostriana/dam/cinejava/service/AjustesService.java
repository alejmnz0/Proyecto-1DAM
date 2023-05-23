package com.salesianostriana.dam.cinejava.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Ajustes;
import com.salesianostriana.dam.cinejava.repository.AjustesRepository;

@Service
public class AjustesService extends BaseServiceImpl<Ajustes, Integer, AjustesRepository>{
	
	public double findPrecioById(int id) {
		return this.repository.findPrecioBaseEntradaById(id);
	}
	
	public double findPrecioVipById(int id) {
		return this.repository.findPrecioVipById(id);
	}

}
