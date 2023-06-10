package src.DTO;

import src.Model.Encuesta;

import java.util.Date;

public class VisitaDTO {
    private Date fechaVisita;

    private String observaciones;

    private Encuesta encuesta;

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public Encuesta getEncuesta() {
        return encuesta;
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
}
