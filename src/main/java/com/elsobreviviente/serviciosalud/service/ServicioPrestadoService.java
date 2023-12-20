package com.elsobreviviente.serviciosalud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.repository.ServicioPrestadoRepo;

@Service
public class ServicioPrestadoService {
	
	@Autowired
	ServicioPrestadoRepo servicioPrestadoRepo;
	
	public List<ServicioPrestado> listaServicioPrestado(){
		return servicioPrestadoRepo.findAll();
	}

}
