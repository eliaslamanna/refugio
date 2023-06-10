package src.Model;

import java.util.*;


public class VisitaADomicilio {

    private Date fechaVisita;

    private String observaciones;

    private Encuesta encuesta;

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

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
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
}