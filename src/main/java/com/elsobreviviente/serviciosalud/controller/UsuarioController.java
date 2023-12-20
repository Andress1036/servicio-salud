package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@GetMapping("/listaUsuario")
	public List<Usuario> listaUsuario(){
		return usuarioService.listaUsuario();
	}
	
	@GetMapping("/listaUsuarioDto")
	public List<UsuarioDto> listaUsuarioDto(){
		return usuarioService.listaUsuarioDto();
	}
	
	@GetMapping("/buscarUsuario/{identificacion}")
	public Usuario buscarUsuario(@PathVariable String identificacion) {
		return usuarioService.buscarUsuario(identificacion);
	}
	
	@GetMapping("/buscarUsuarioPorLetra/{cadena}")
	public List<Usuario> listaUsuarioPorLetra(@PathVariable String cadena){
		return usuarioService.bucarUsuarioPorLetra(cadena);
	}
	
	@GetMapping("/buscarUsuarioDtoPorLetra/{cadena}")
	public List<UsuarioDto> listaUsuarioDtoPorLetra(@PathVariable String cadena){
		return usuarioService.buscarUsuarioDtoPorLetra(cadena);
	}
	
	
	
	@PostMapping("/almacenarUsuario")
	public Usuario almacenarUsuario (@RequestBody Usuario usuario) {
		return usuarioService.almacenarUsuario(usuario);
	}
	
	@PostMapping("/almacenarUsuarioDto")
	public UsuarioDto almacenarUsuarioDto (@RequestBody UsuarioDto usuarioDto) {
		return usuarioService.almacenarUsuarioDtoV1(usuarioDto);
	}
	
	
	
	
	@PutMapping("/actualizarUsuario")
	public Usuario actualizarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.actualizarUsuario(usuario);
	}
	

	
	
	@DeleteMapping("/borrarUsuario/{identificacion}")
	public void borrarUsuario(@PathVariable String identificacion) {
		usuarioService.borrarUsuario(identificacion);
	}
	
	
	
	
}
