package com.youtube.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.youtube.app.usuarios.models.entity.Usuario;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {

}
