package com.salesianostriana.dam.cinejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long fila;
	private long columna;

	@ManyToOne
	private Sala sala;

	private boolean vip;

	public Asiento(long fila, long columna, Sala sala, boolean vip) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.sala = sala;
		this.vip = vip;
	}

}