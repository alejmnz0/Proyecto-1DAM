package com.salesianostriana.dam.cinejava.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true) //eliminar los huerfanos (asientos sin sala)
	private List<Asiento> asientos= new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "sala", fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true) //eliminar los huerfanos (asientos sin sala)
	private List<Pase> pases= new ArrayList<>();
	
	public void addAsiento(Asiento a) {
		a.setSala(this);
		this.asientos.add(a);
	}
	
	public void removeAsiento(Asiento a) {
		this.asientos.remove(a);
		a.setSala(null);
	}
	
	public void addPase(Pase p) {
		p.setSala(this);
		this.pases.add(p);
	}
	
	public void removePase(Pase p) {
		this.pases.remove(p);
		p.setSala(null);
	}
}