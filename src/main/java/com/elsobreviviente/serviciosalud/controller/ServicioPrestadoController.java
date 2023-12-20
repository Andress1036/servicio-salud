package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.service.ServicioPrestadoService;

@RestController
@RequestMapping("/api/servicioPrestado")
public class ServicioPrestadoController {
	
	@Autowired
	ServicioPrestadoService servicioPrestadoService;
	
	@GetMapping("/listaServicioPrestado")
	public List<ServicioPrestado> listaServicioPrestado(){
		return servicioPrestadoService.listaServicioPrestado();
	}

}
