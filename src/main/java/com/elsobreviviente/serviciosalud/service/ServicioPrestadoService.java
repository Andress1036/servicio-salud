package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.ServicioPrestadoDto;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.repository.ServicioPrestadoRepo;

@Service
public class ServicioPrestadoService {
	
	@Autowired
	ServicioPrestadoRepo servicioPrestadoRepo;
	
	public List<ServicioPrestado> listaServicioPrestado(){
		return servicioPrestadoRepo.findAll();
	
	}

	

	public List<ServicioPrestadoDto> listaServicioPrestadoDto(){
		List<ServicioPrestadoDto> listaSPDto = new ArrayList<>();
		List<ServicioPrestado> listaServicioPrestado = servicioPrestadoRepo.findAll();

		for (ServicioPrestado servicioPrestado: listaServicioPrestado){
			try{
			ServicioPrestadoDto servicioPrestadoDto = new ServicioPrestadoDto(servicioPrestado);
			listaSPDto.add(servicioPrestadoDto);
			} catch(Exception e){
				System.out.println("Error!!!!!"+e);
			}
		}
		return listaSPDto;
	}
}
