package com.salesianostriana.dam.cinejava.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorioClientes;
	
	public ClienteService(ClienteRepository repo) {
		this.repositorioClientes = repo;
	}
	
	public Usuario add (Usuario c) {
		return repositorioClientes.save(c);
	}
	
	public Usuario edit (Usuario c) {
		return repositorioClientes.save(c);
	}
	
	public void delete (Usuario c) {
		repositorioClientes.delete(c);
	}
	
	public void delete (long id) {
		repositorioClientes.deleteById(id);
	}
	
	public List<Usuario> findAll () {
		return repositorioClientes.findAll();
	}
	
	public Usuario findById (Long id) {
		return repositorioClientes.findById(id).orElse(null);
	}
	
}
