package com.elsobreviviente.serviciosalud.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column (name = "identificacion")
	private String identificacion;
	
	@Column (name = "nombre_completo")
	private String nombreCompleto;
	
	@OneToMany ( mappedBy = "usuario")
	private List<ServicioPrestado> servicioPrestadoList = new ArrayList<>();
	
	public Usuario () {
		
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

	public List<ServicioPrestado> getServicioPrestadoList() {
		return servicioPrestadoList;
	}

	public void setServicioPrestadoList(List<ServicioPrestado> servicioPrestadoList) {
		this.servicioPrestadoList = servicioPrestadoList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificacion, nombreCompleto, servicioPrestadoList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(identificacion, other.identificacion)
				&& Objects.equals(nombreCompleto, other.nombreCompleto)
				&& Objects.equals(servicioPrestadoList, other.servicioPrestadoList);
	}

	@Override
	public String toString() {
		return "Usuario [identificacion=" + identificacion + ", nombreCompleto=" + nombreCompleto
				+ ", servicioPrestadoList=" + servicioPrestadoList + "]";
	}
	

	
	

	
	
}
