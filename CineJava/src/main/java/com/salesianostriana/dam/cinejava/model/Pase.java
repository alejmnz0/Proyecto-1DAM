package com.salesianostriana.dam.cinejava.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pase;
	@Id
	private LocalDateTime fecha;
	
	@ManyToMany
	private Sala sala;
	
	
}
