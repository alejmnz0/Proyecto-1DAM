package com.salesianostriana.dam.cinejava.service; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorioUsuarios;
	
	public UsuarioService(UsuarioRepository repo) {
		this.repositorioUsuarios = repo;
	}
	
	public Usuario add (Usuario c) {
		return repositorioUsuarios.save(c);
	}
	
	public Usuario edit (Usuario c) {
		return repositorioUsuarios.save(c);
	}
	
	public void delete (Usuario c) {
		repositorioUsuarios.delete(c);
	}
	
	public void delete (long id) {
		repositorioUsuarios.deleteById(id);
	}
	
	public List<Usuario> findAll () {
		return repositorioUsuarios.findAll();
	}
	
	public Usuario findById (Long id) {
		return repositorioUsuarios.findById(id).orElse(null);
	}
	
}
