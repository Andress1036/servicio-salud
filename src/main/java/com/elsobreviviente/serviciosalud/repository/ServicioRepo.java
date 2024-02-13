package com.elsobreviviente.serviciosalud.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.Servicio;



@Repository
public interface ServicioRepo extends JpaRepository<Servicio, Long>{

    List<Servicio> findByNombreServicioContainingIgnoreCase(String cadena);
    List<Servicio> findByCodigoServicioContaining(String cadena);
    Servicio getReferenceByCodigoServicio(String codigoServicio);

    @Query("SELECT s FROM Servicio s WHERE s.codigoServicio = :codigoServicio")
    Servicio findByCodigoServicio(@Param("codigoServicio") String codigoServicio);

    
}
