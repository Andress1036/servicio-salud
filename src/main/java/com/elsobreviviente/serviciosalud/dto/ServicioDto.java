package com.elsobreviviente.serviciosalud.dto;



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

	
	public Long getIdCodigoServicio() {
		return idCodigoServicio;
	}

	public void setIdCodigoServicio(Long idCodigoServicio) {
		this.idCodigoServicio = idCodigoServicio;
	}

	public String getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}


}
