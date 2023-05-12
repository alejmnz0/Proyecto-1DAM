package com.salesianostriana.dam.cinejava.service; 

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.cinejava.model.Usuario;
import com.salesianostriana.dam.cinejava.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repositorioUsuarios;
	private final PasswordEncoder passwordEncoder;
	
	public Usuario add (Usuario c) {
		c.setPassword(passwordEncoder.encode(c.getPassword()));
		return repositorioUsuarios.save(c);
	}
	
	public Usuario edit (Usuario c) {
		c.setPassword(passwordEncoder.encode(c.getPassword()));
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
