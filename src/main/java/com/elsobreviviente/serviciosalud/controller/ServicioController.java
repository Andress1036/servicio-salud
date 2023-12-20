package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.ServicioDto;
import com.elsobreviviente.serviciosalud.dto.ServicioDto2;
import com.elsobreviviente.serviciosalud.dto.ServicioDtoId;
import com.elsobreviviente.serviciosalud.entity.Servicio;
import com.elsobreviviente.serviciosalud.service.ServicioService;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {
	
	@Autowired
	ServicioService servicioService;
	
	@GetMapping("/listaServicioDto")
	public List<ServicioDto> listaServicioDto(){
		return servicioService.listaServicioDto();
	}
	
	//ESTA FALLANDO Y NO SÉ EL POR QUÉ.
	@GetMapping("/listaServicio") 
	public List<Servicio> listaServicio(){
		return servicioService.listaServicio();
	}
	
	/*
	@GetMapping("/listaServicioDto2")
	public List<ServicioDto2> listaServicioDto2(){
		return servicioService.listaServicioDto2();
	}
	*/

	@PostMapping("/guardarServicioDto2")
	public ServicioDto2 guardarServicioDto2(@RequestBody ServicioDto2 servicioDto2) {
		return servicioService.guardarServicioDto2(servicioDto2);
	}
	
	
	
	@PutMapping("/actualizarServicioDto2")
	public ServicioDto2 actualizarDto2 (@RequestBody ServicioDto2 servicioDto2) {
		return servicioService.actualizarServicioDto2(servicioDto2);
	}
	
	@DeleteMapping("/borrarServicio")
	public void borrarServicio(@RequestBody ServicioDtoId servicioDtoId) {
		servicioService.borrarServicio(servicioDtoId);
	}
}
