package com.salesianostriana.dam.cinejava.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {

	@Id
	private int fila,columna;
	
	@Id
	@ManyToOne
	private Sala sala;
	
	private boolean vip;
}
