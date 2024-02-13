package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.ServicioPrestadoDto;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.repository.ServicioPrestadoRepo;
import com.elsobreviviente.serviciosalud.repository.ServicioRepo;
import com.elsobreviviente.serviciosalud.repository.UsuarioRepository;

@Service
public class ServicioPrestadoService {

	@Autowired
	UsuarioRepository usuarioRepository;
	ServicioRepo servicioRepo;
	
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


	public ServicioPrestadoDto guardarSPDto(ServicioPrestadoDto servicioPrestadoDto){
		ServicioPrestado servicioPrestado = new ServicioPrestado();

		servicioPrestado.setUsuario(usuarioRepository.getReferenceById(servicioPrestadoDto.getUsuario()));
		//En el setServicio se hizo una modificación en el repository de Servicio, para usar un atributo diferente al Id,
		//en este caso el atributo que se usó es el de codigoServicio, como referente de la entity Servicio.
		servicioPrestado.setServicio(servicioRepo.getReferenceByCodigoServicio(servicioPrestadoDto.getServicio()));

		servicioPrestadoRepo.save(servicioPrestado);

		return servicioPrestadoDto;
		
	}

}
