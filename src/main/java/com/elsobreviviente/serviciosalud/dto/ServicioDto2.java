package com.elsobreviviente.serviciosalud.dto;


public class ServicioDto2 {

	private Long idCodigoServicio; //Auto-incrementado
	private String codigoServicio;
	private String nombreServicio;
	private String tipoServicio;
	
	public ServicioDto2() {
		
	}
		

	public ServicioDto2(String codigoServicio, String nombreServicio, String tipoServicio) {
	
		this.codigoServicio = codigoServicio;
		this.nombreServicio = nombreServicio;
		this.tipoServicio = tipoServicio;
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


	public String getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	
}
