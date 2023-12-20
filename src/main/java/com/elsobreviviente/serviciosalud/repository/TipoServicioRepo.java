package com.elsobreviviente.serviciosalud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.TipoServicio;

@Repository
public interface TipoServicioRepo extends JpaRepository<TipoServicio, String> {

	

}
