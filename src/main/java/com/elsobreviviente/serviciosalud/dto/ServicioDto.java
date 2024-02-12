package com.elsobreviviente.serviciosalud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioDto {

	private Long idCodigoServicio;
	private String codigoServicio;
	private String nombreServicio;
	
	
	public ServicioDto() {
		
	}

	public ServicioDto(Long idCodigoServicio, String codigoServicio, String nombreServicio) {
		this.idCodigoServicio = idCodigoServicio;
		this.codigoServicio = codigoServicio;
		this.nombreServicio = nombreServicio;
		
	}

}
