package com.elsobreviviente.serviciosalud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.Servicio;


@Repository
public interface ServicioRepo extends JpaRepository<Servicio, Long>{

	

}
