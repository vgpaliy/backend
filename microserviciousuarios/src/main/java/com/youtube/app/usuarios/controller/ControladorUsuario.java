package com.youtube.app.usuarios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.app.usuarios.models.entity.Usuario;
import com.youtube.app.usuarios.services.ServicioUsuario;

@RestController
public class ControladorUsuario {

	@Autowired
	private ServicioUsuario serviciousuario;
	
	//mapeamos
	@GetMapping
	public ResponseEntity<?> devolverUsuarios(){
		return ResponseEntity.ok().body(serviciousuario.findALL());
	} 
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverUsuario(@PathVariable Long id){
		Optional <Usuario> us =serviciousuario.findUserById(id);
		if (us.isEmpty()) {
			return ResponseEntity.notFound().build();	
			}else {
			return ResponseEntity.ok(us.get());
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable Long id){
		serviciousuario.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
	@PostMapping
	public ResponseEntity<?> addUsuario (@RequestBody Usuario usuario){ //de ese usuarios no estoy seguro
		Usuario usu=	serviciousuario.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usu);
	}
	//Modificar parametros de un usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> editaUsuario(@RequestBody Usuario usuario, @PathVariable Long id){
		Optional<Usuario> usu = serviciousuario.findUserById(id);
		if(usu.isEmpty()) {
			return ResponseEntity.notFound().build();
			}
		Usuario objusu = usu.get();
		objusu.setEmail(usuario.getEmail());
		objusu.setName(usuario.getName());
		objusu.setSecond_name(usuario.getSecond_name());
		objusu.setPassword(usuario.getPassword());
		Usuario objusu2 = serviciousuario.save(objusu);
		return ResponseEntity.status(HttpStatus.CREATED).body(objusu2);
	}
}
	


