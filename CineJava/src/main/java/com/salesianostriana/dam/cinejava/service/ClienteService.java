package com.salesianostriana.dam.cinejava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Cliente;
import com.salesianostriana.dam.cinejava.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repositorioClientes;
	
	public ClienteService(ClienteRepository repo) {
		this.repositorioClientes = repo;
	}
	
	public Cliente add (Cliente c) {
		return repositorioClientes.save(c);
	}
	
	public Cliente edit (Cliente c) {
		return repositorioClientes.save(c);
	}
	
	public void delete (long id) {
		repositorioClientes.deleteById(id);
	}
	
	public List<Cliente> findAll () {
		return repositorioClientes.findAll();
	}
	
	public Cliente findById (Long id) {
		return repositorioClientes.findById(id).orElse(null);
	}
	
}
