package com.salesianostriana.dam.cinejava.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Pase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pase;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_pase_sala"))
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_pase_pelicula"))
	private Pelicula peli;
	
	private LocalDateTime fecha;
	
	
}