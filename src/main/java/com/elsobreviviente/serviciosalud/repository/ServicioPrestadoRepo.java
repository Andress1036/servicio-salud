package com.elsobreviviente.serviciosalud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import java.util.List;


@Repository
public interface ServicioPrestadoRepo extends JpaRepository<ServicioPrestado, Long>{

    List<ServicioPrestado> findByIdServicioPrestado(Long idServicioPrestado);
}
