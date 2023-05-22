package com.youtube.app.usuarios.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youtube.app.usuarios.models.entity.Usuario;
import com.youtube.app.usuarios.models.repository.RepositorioUsuario;

@Service
public class ServicioImplUsuario implements ServicioUsuario {

	@Autowired
	private RepositorioUsuario repositoriousuario;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Usuario> findALL() {
		return repositoriousuario.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findUserById(long id) {
		return repositoriousuario.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return repositoriousuario.save(usuario);
	}

	@Override
	public void deleteUserById(long id) {
		repositoriousuario.deleteById(id);
	}

}
