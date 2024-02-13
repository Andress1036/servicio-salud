package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.UsuarioDto;
import com.elsobreviviente.serviciosalud.entity.Usuario;
import com.elsobreviviente.serviciosalud.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/listaUsuario")
	public ResponseEntity<List<Usuario>> listaUsuario(){
		return new ResponseEntity<>(usuarioService.listaUsuario(),HttpStatus.OK);
	}
	
	@GetMapping("/listaUsuarioDto")
	public ResponseEntity<List<UsuarioDto>> listaUsuarioDto(){
		return new ResponseEntity<>(usuarioService.listaUsuarioDto(),HttpStatus.OK);
	}
	
	@GetMapping("/buscarUsuario/{identificacion}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable String identificacion) {
		return new ResponseEntity<>(usuarioService.buscarUsuario(identificacion),HttpStatus.FOUND);
	}
	
	@GetMapping("/buscarUsuarioPorLetra/{cadena}")
	public ResponseEntity<List<Usuario>> listaUsuarioPorLetra(@PathVariable String cadena){
		return new ResponseEntity<>(usuarioService.bucarUsuarioPorLetra(cadena),HttpStatus.FOUND);
	}
	
	@GetMapping("/buscarUsuarioDtoPorLetra/{cadena}")
	public ResponseEntity<List<UsuarioDto>> listaUsuarioDtoPorLetra(@PathVariable String cadena){
		return new ResponseEntity<>(usuarioService.buscarUsuarioDtoPorLetra(cadena),HttpStatus.FOUND);
	}
	
	
	
	@PostMapping("/almacenarUsuario")
	public ResponseEntity<Usuario> almacenarUsuario (@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.almacenarUsuario(usuario),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/almacenarUsuarioDto")
	public ResponseEntity<UsuarioDto> almacenarUsuarioDto (@RequestBody UsuarioDto usuarioDto) {
		return new ResponseEntity<>(usuarioService.almacenarUsuarioDtoV1(usuarioDto),HttpStatus.ACCEPTED);
	}
	
	
	
	
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<>(usuarioService.actualizarUsuario(usuario),HttpStatus.ACCEPTED);
	}
	

	// Delete desactivado
	/*
	@DeleteMapping("/borrarUsuario/{identificacion}")
	public void borrarUsuario(@PathVariable String identificacion) {
		usuarioService.borrarUsuario(identificacion);
	}
	*/
	
	
	
}
