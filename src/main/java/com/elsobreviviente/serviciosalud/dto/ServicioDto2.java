package com.elsobreviviente.serviciosalud.dto;

import com.elsobreviviente.serviciosalud.entity.Servicio;

public class ServicioDto2 {

	private Long idCodigoServicio; // Auto-incrementado
	private String codigoServicio;
	private String nombreServicio;
	private String codigoTipoServicio;

	public ServicioDto2() {

	}

	public ServicioDto2(Servicio servicio) {
		this.idCodigoServicio = servicio.getIdCodigoServicio();
		this.codigoServicio = servicio.getCodigoServicio();
		this.nombreServicio = servicio.getNombreServicio();
		this.codigoTipoServicio = servicio.getTipoServicio().toString();

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

	public String getCodigoTipoServicio() {
		return codigoTipoServicio;
	}

	public void setCodigoTipoServicio(String codigoTipoServicio) {
		this.codigoTipoServicio = codigoTipoServicio;
	}

}
