package com.elsobreviviente.serviciosalud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import org.springframework.web.bind.annotation.RequestParam;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/servicio")
public class ServicioController {
	
	@Autowired
	ServicioService servicioService;
	
	//llama al servicio sin el objeto TipoServicio
	@GetMapping("/listaServicioDto")
	public ResponseEntity<List<ServicioDto>> listaServicioDto(){
		if (servicioService.listaServicioDto().isEmpty()){
		return new ResponseEntity<>(servicioService.listaServicioDto(), HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	}
	
	//ESTA FALLANDO Y NO SÉ EL POR QUÉ 
	//(Creo que debe ser porque uno de sus atributos es un objeto y el json solo lee string).
	//Se cae todo el servicio, pero con solo cambiar a un getmapping con dto vuelve a funcionar el
	//sistema, como si no hubiese un problema
	@GetMapping("/listaServicio") 
	public List<Servicio> listaServicio(){
		return servicioService.listaServicio();
	}
	
	//Funcionando, pero con una modificación del constructor con parametros del Dto ServicioDto2
	// para que el Servicio pueda ser leido con el objeto TipoServicio, también modifiqué, el
	// entity TipoServicio en la parte del toString, para que se pueda leer el codigoTipoServicio
	@GetMapping("/listaServicioDto2")
	public ResponseEntity<List<ServicioDto2>> listaServicioDto2(){
		if (servicioService.listaServicioDto2().isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} else {
		return new ResponseEntity<>(servicioService.listaServicioDto2(),HttpStatus.OK);
	}
	}

	@GetMapping("/buscarServicioDto2PorLetra/{cadena}")
	public ResponseEntity<List<ServicioDto2>> buscarServicioDto2PorLetra(@PathVariable String cadena) {
		return new ResponseEntity<>(servicioService.buscarServicioDto2PorLetra(cadena),HttpStatus.FOUND);
	}
	
		

	//Sin el tipoServicio
	@PostMapping("/guardarServicioDto")
	public ResponseEntity<ServicioDto> guardarServicioDto(@RequestBody ServicioDto servicioDto) {
		return new ResponseEntity<>(servicioService.guardarServicioDto(servicioDto),HttpStatus.ACCEPTED);
	}

	//Con el TipoServicio
	@PostMapping("/guardarServicioDto2")
	public ResponseEntity<ServicioDto2> guardarServicioDto2(@RequestBody ServicioDto2 servicioDto2) {
		return new ResponseEntity<>(servicioService.guardarServicioDto2(servicioDto2),HttpStatus.ACCEPTED);
	}
	
	
	
	@PutMapping("/actualizarServicioDto2")
	public ResponseEntity<ServicioDto2> actualizarDto2 (@RequestBody ServicioDto2 servicioDto2) {
		return new ResponseEntity<>(servicioService.actualizarServicioDto2(servicioDto2), HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping("/borrarServicio")
	public void borrarServicio(@RequestBody ServicioDtoId servicioDtoId) {
		servicioService.borrarServicio(servicioDtoId);
	}
}
