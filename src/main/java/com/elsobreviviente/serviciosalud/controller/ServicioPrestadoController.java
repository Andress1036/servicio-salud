package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.serviciosalud.dto.ServicioPrestadoDto;
import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;
import com.elsobreviviente.serviciosalud.service.ServicioPrestadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/servicioPrestado")
public class ServicioPrestadoController {
	
	@Autowired
	ServicioPrestadoService servicioPrestadoService;
	
	@GetMapping("/listaServicioPrestado")
	public ResponseEntity<List<ServicioPrestado>> listaServicioPrestado(){
		if (servicioPrestadoService.listaServicioPrestado().isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
		return new ResponseEntity<>(servicioPrestadoService.listaServicioPrestado(), HttpStatus.OK);
		}
	}

	@GetMapping("/listaServicioPrestadoDto")
	public ResponseEntity<List<ServicioPrestadoDto>> listaServicioPrestadoDto(){
		if (servicioPrestadoService.listaServicioPrestadoDto().isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
		return new ResponseEntity<>(servicioPrestadoService.listaServicioPrestadoDto(),HttpStatus.OK);
		}
	}

	

	@PostMapping("/agregarServicioPrestadoDto")
	public ServicioPrestadoDto agregarServicioPrestadoDto(@RequestBody ServicioPrestadoDto servicioPrestadoDto){
		return servicioPrestadoService.guardarSPDto(servicioPrestadoDto);
	}
	

}
