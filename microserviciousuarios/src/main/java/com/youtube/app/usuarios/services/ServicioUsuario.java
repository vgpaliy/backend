package com.youtube.app.usuarios.services;

import java.util.Optional;

import com.youtube.app.usuarios.models.entity.Usuario;

public interface ServicioUsuario {

	public  Iterable <Usuario> findALL();
	public Optional<Usuario> findUserById(long id);
	public Usuario save (Usuario usuario);
	public void deleteUserById(long id);
}
