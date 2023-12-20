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
	
	public List<Servicio> listaServicio(){
		return servicioRepo.findAll();
	}
	//lista ServicioDto con el TipoServicio
	public List<ServicioDto> listaServicioDto(){
		List<ServicioDto> listaServicioDto = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findAll();
		
		for (Servicio servicio : listaServicio) {
			ServicioDto servicioDto = new ServicioDto(servicio.getIdCodigoServicio(), servicio.getCodigoServicio(), servicio.getNombreServicio());
			listaServicioDto.add(servicioDto);
		}
		return listaServicioDto;
		
	}
	/*
	public List<ServicioDto2> listaServicioDto2(){
		List<ServicioDto2> listaServicioDto2 = new ArrayList<>();
		List<Servicio> listaServicio = servicioRepo.findAll();
		
		for (Servicio servicio : listaServicio) {
			ServicioDto2 servicioDto2 = new ServicioDto2();
			servicioDto2.setIdCodigoServicio(servicio.getIdCodigoServicio());
			servicioDto2.setCodigoServicio(servicio.getCodigoServicio());
			servicioDto2.setNombreServicio(servicio.getNombreServicio());
			
			
			 * TipoServicio tipoServicio = servicio.getTipoServicio();
			String codigoTipoServicio = servicioRepo.getReferenceById(tipoServicio);
			servicioDto2.setTipoServicio(codigoTipoServicio);
			
			
			
			listaServicioDto2.add(servicioDto2);
			
			
		}
		return  listaServicioDto2;
	}
	*/
	//Almacenar servicio con Tipo Servicio como String en el Dto2
	public ServicioDto2 guardarServicioDto2(ServicioDto2 servicioDto2) {
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		servicio.setTipoServicio(tipoServicioRepo.getReferenceById(servicioDto2.getTipoServicio())); //Versión corta
		
		/* Versio larga
		 * 
		String codigoTipoServicio = servicioDto2.getTipoServicio();
		TipoServicio tipoServicio = tipoServicioRepo.getReferenceById(codigoTipoServicio);
		servicio.setTipoServicio(tipoServicio);
		 */
		
		servicioRepo.save(servicio);		
		return servicioDto2;
	}
	
	//Actuliazar con el idCodigoServicio del ServicioDto2
	public ServicioDto2 actualizarServicioDto2 (ServicioDto2 servicioDto2) {
		Servicio servicio = servicioRepo.getReferenceById(servicioDto2.getIdCodigoServicio());
		servicio.setCodigoServicio(servicioDto2.getCodigoServicio());
		servicio.setNombreServicio(servicioDto2.getNombreServicio());
		//Pasando de String a TipoServicio
		String codigoTipoServicio = servicioDto2.getTipoServicio();
		TipoServicio tipoServicio = tipoServicioRepo.getReferenceById(codigoTipoServicio);
		servicio.setTipoServicio(tipoServicio);
		
		servicioRepo.save(servicio);
		return servicioDto2;
	}
	
	public void borrarServicio(ServicioDtoId servicioDtoId) {
		
	Servicio servicio =	servicioRepo.getReferenceById(servicioDtoId.getIdCodigoServicio());
		servicioRepo.delete(servicio);
	}
	
}
