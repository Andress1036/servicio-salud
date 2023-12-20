package com.elsobreviviente.serviciosalud.dto;

public class UsuarioDto {

	private String identificacion;
	private String nombreCompleto;
	
	public UsuarioDto(String identificacion, String nombreCompleto) {
		this.identificacion = identificacion;
		this.nombreCompleto = nombreCompleto;
	}

	public UsuarioDto() {
		
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	
}
