package com.salesianostriana.dam.cinejava.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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

	@EmbeddedId
	private AsientoId id;
	
	@MapsId("salaId")
	@ManyToOne
	private Sala sala;
	
	private boolean vip;
}