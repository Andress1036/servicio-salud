package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.UsuarioDto;
import com.elsobreviviente.serviciosalud.entity.Usuario;
import com.elsobreviviente.serviciosalud.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> listaUsuario(){
		return usuarioRepository.findAll();
	}
	
	public List<UsuarioDto> listaUsuarioDto(){
		List<UsuarioDto> listaUsuarioDto = new ArrayList<>();
		
		for (Usuario usuario: listaUsuario()) {
			UsuarioDto usuarioDto = new UsuarioDto(usuario.getIdentificacion(), usuario.getNombreCompleto());
					listaUsuarioDto.add(usuarioDto);
		}
		return listaUsuarioDto;
	}
	
	public Usuario almacenarUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	//UsuarioDto a Usuario version larga y entendible
	public UsuarioDto almacenarUsuarioDtoV1 (UsuarioDto usuarioDto) {
		//convertir dto a entity
		Usuario usuario = new Usuario();
		usuario.setIdentificacion(usuarioDto.getIdentificacion());
		usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
		usuarioRepository.save(usuario); // persistencia
		return usuarioDto;
	}
	
	public Usuario actualizarUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void borrarUsuario(String identificacion) {
		usuarioRepository.deleteById(identificacion);
	}
	
	public Usuario buscarUsuario(String identificacion) {
		return usuarioRepository.findById(identificacion).orElse(null);
	}
	
	public List<Usuario> bucarUsuarioPorLetra(String cadena){
		return usuarioRepository.findByNombreCompletoContainingIgnoreCase(cadena);
	}
	
	public List<UsuarioDto> buscarUsuarioDtoPorLetra(String cadena){
		List<UsuarioDto> listaUsuarioDto = new ArrayList<>();
		List<Usuario> listaUsuario = usuarioRepository.findByNombreCompletoContainingIgnoreCase(cadena);
		
		for (Usuario usuario : listaUsuario) {
			UsuarioDto usuarioDto = new UsuarioDto(usuario.getIdentificacion(), usuario.getNombreCompleto());
			listaUsuarioDto.add(usuarioDto);
		}
		
		return listaUsuarioDto;
	}
}
