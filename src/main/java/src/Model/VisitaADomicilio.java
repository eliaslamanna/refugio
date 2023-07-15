package src.Model;

import src.DTO.EncuestaDTO;
import src.DTO.VisitaADomicilioDTO;

import java.util.*;


public class VisitaADomicilio {

    private Date fechaVisita;

    private String observaciones;

    private Encuesta encuesta;

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }

    private boolean terminada;

    public VisitaADomicilio(Date fechaVisita, String observaciones, Encuesta encuesta) {
        this.fechaVisita = fechaVisita;
        this.observaciones = observaciones;
        this.encuesta = encuesta;
        this.terminada = false;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEncuesta(EncuestaDTO encuesta) {
        this.encuesta.setAmbiente(encuesta.getAmbiente());
        this.encuesta.setEstado(encuesta.getEstado());
        this.encuesta.setLimpieza(encuesta.getLimpieza());
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public VisitaADomicilioDTO toDTO(){
        VisitaADomicilioDTO visitaDTO = new VisitaADomicilioDTO();
        visitaDTO.setEncuesta(encuesta.toDTO());
        visitaDTO.setFechaVisita(this.fechaVisita);
        visitaDTO.setObservaciones(this.observaciones);
        visitaDTO.setTerminada(this.terminada);

        return visitaDTO;
    }
}