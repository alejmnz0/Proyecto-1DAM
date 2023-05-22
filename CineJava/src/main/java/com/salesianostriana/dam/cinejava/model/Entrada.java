package com.salesianostriana.dam.cinejava.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
public class Entrada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_entrada;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_entrada_pase"))
	private Pase pase;
	
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "fila", referencedColumnName = "fila"),
	    @JoinColumn(name = "columna", referencedColumnName = "columna"),
	    @JoinColumn(name = "sala_id", referencedColumnName = "sala_id")
	})
	private Asiento asiento;
	
	private double precio;
	
}