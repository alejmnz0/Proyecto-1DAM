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
	
	public Usuario add (Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return repositorioUsuarios.save(u);
	}
	
	public Usuario edit (Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return repositorioUsuarios.save(u);
	}
	
	public void delete (Usuario u) {
		repositorioUsuarios.delete(u);
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
