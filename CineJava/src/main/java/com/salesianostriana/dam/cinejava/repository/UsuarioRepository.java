package com.salesianostriana.dam.cinejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.cinejava.model.Usuario;

public interface ClienteRepository extends JpaRepository<Usuario, Long>{

}
