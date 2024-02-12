package com.elsobreviviente.serviciosalud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.serviciosalud.dto.ServicioDto;
import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioDtoId;
import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.entity.TipoServicio;
import com.elsobreviviente.serviciosalud.repository.ServicioRepo;
import com.elsobreviviente.serviciosalud.repository.TipoServicioRepo;

@Service
public class ServicioService {

	@Autowired
	ServicioRepo servicioRepo;
	
	@Autowired
	TipoServicioRepo tipoServicioRepo;
	
	
// Metodo con falla al ser llamado en el controller, no estoy seguro del por qué
	public List<Servicio> listaServicio(){
		return servicioRepo.findAll();
	}

	//lista ServicioDto sin el TipoServicio
	public List<ServicioDto> listaServicioDto(){
		List<ServicioDto> listaServicioDto = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findAll();
		
		for (Servicio servicio : listaServicio) {
			ServicioDto servicioDto = new ServicioDto(servicio.getIdCodigoServicio(), servicio.getCodigoServicio(), servicio.getNombreServicio());
			listaServicioDto.add(servicioDto);
		}
		return listaServicioDto;
		
	}

	
			// listaServicioDto2() en fase de prueba
			// Tuve que ponerle el try..catch, para que funcionara correctamente, y se tenga manejo de error.
	public List<ServicioDto2> listaServicioDto2(){
		
		List<ServicioDto2> listaServicioDto2 = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findAll();
		for (Servicio servicio : listaServicio) {
		try {			
			ServicioDto2 servicioDto2 = new ServicioDto2(servicio);
			listaServicioDto2.add(servicioDto2);
		} catch (Exception e) {
			System.out.println("Error!!!" + e);
			// TODO: handle exception
		}
			
		}
		return  listaServicioDto2;

		
	}


  //ALMACENAR servicio sin el TipoServicio
	public ServicioDto guardarServicioDto (ServicioDto servicioDto) {
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio(servicioDto.getCodigoServicio());
		servicio.setNombreServicio(servicioDto.getNombreServicio());

		servicioRepo.save(servicio);
		return servicioDto;
	}

	//ALMACENAR servicio con TipoServicio como String en el Dto2
	public ServicioDto2 guardarServicioDto2(ServicioDto2 servicioDto2) {
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		servicio.setTipoServicio(tipoServicioRepo.getReferenceById(servicioDto2.getCodigoTipoServicio())); //Versión corta
		
		// Versión larga
		 /*
		String codigoTipoServicio = servicioDto2.getCodigoTipoServicio();
		TipoServicio tipoServicio = tipoServicioRepo.getReferenceById(codigoTipoServicio);
		servicio.setTipoServicio(tipoServicio);
		 */		
		
		servicioRepo.save(servicio);		

		return servicioDto2;
	}

	
	
	//ACTUALIZAR con el idCodigoServicio del ServicioDto2
	public ServicioDto2 actualizarServicioDto2 (ServicioDto2 servicioDto2) {
		Servicio servicio = servicioRepo.getReferenceById(servicioDto2.getIdCodigoServicio());
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		//Pasando de String a TipoServicio
		String codigoTipoServicio = servicioDto2.getCodigoTipoServicio();
		TipoServicio tipoServicio = tipoServicioRepo.getReferenceById(codigoTipoServicio);
		servicio.setTipoServicio(tipoServicio);
		
		servicioRepo.save(servicio);
		return servicioDto2;
	}
	

public List<ServicioDto2> buscarServicioDto2PorLetra(String cadena){
		List<ServicioDto2> listaServicioDto2 = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findByNombreServicioContainingIgnoreCase(cadena);
		
		for (Servicio servicio : listaServicio) {
			ServicioDto2 servicioDto2Dto = new ServicioDto2(servicio);
			listaServicioDto2.add(servicioDto2Dto);
		}
		
		return listaServicioDto2;
	}



	//BORRAR servicio
	public void borrarServicio(ServicioDtoId servicioDtoId) {
		
	Servicio servicio =	servicioRepo.getReferenceById(servicioDtoId.getIdCodigoServicio());
		servicioRepo.delete(servicio);
	}
	
}
