package com.elsobreviviente.serviciosalud.dto;

import com.elsobreviviente.serviciosalud.entity.ServicioPrestado;



public class ServicioPrestadoDto {

    

    private long idServicioPrestado;
    private String usuario;
    private String servicio;

    public ServicioPrestadoDto (ServicioPrestado servicioPrestado){
        this.idServicioPrestado = servicioPrestado.getIdServicioPrestado();
        this.usuario = servicioPrestado.getUsuario().getIdentificacion();
        this.servicio = servicioPrestado.getServicio().getCodigoServicio();

    }

    public long getIdServicioPrestado() {
        return idServicioPrestado;
    }

    public void setIdServicioPrestado(long idServicioPrestado) {
        this.idServicioPrestado = idServicioPrestado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

     public String getServicio() {
        return servicio;
    } 

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    
}