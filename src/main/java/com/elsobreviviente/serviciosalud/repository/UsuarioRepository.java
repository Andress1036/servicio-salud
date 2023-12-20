package com.elsobreviviente.serviciosalud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, String> {

	List<Usuario> findByNombreCompletoContainingIgnoreCase(String cadena);
	List<Usuario> findByNombreCompletoStartingWithIgnoreCase(String cadena);
	
}
