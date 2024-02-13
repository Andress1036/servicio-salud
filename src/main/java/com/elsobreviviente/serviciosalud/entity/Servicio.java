package com.elsobreviviente.serviciosalud.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_codigo_servicio")
	private Long idCodigoServicio;
	@Column(name = "codigo_servicio")
	private String codigoServicio;
	@Column(name = "nombre_servicio")
	private String nombreServicio;

	@ManyToOne
	@JoinColumn(name = "codigo_tipo_servicio", referencedColumnName = "codigo_tipo_servicio")
	private TipoServicio tipoServicio;
	@OneToMany(mappedBy = "servicio")
	private List<ServicioPrestado> listaServicioPrestado = new ArrayList<>();

	public Servicio() {

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

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public List<ServicioPrestado> getListaServicioPrestado() {
		return listaServicioPrestado;
	}

	public void setListaServicioPrestado(List<ServicioPrestado> listaServicioPrestado) {
		this.listaServicioPrestado = listaServicioPrestado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoServicio, idCodigoServicio, listaServicioPrestado, nombreServicio, tipoServicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(codigoServicio, other.codigoServicio)
				&& Objects.equals(idCodigoServicio, other.idCodigoServicio)
				&& Objects.equals(listaServicioPrestado, other.listaServicioPrestado)
				&& Objects.equals(nombreServicio, other.nombreServicio)
				&& Objects.equals(tipoServicio, other.tipoServicio);
	}

}
