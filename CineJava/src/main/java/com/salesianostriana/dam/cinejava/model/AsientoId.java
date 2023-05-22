package com.salesianostriana.dam.cinejava.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AsientoId implements Serializable {

    private long fila;
    private long columna;
    private long salaId;

}
