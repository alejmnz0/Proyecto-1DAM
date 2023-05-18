package com.salesianostriana.dam.cinejava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;

//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	@Builder.Default
//	@OneToMany(mappedBy = "sala", fetch = FetchType.EAGER,
//		cascade = CascadeType.ALL,
//		orphanRemoval = true) //eliminar los huerfanos (asientos sin sala)
//	private List<Asiento> asientos= new ArrayList<>();
}