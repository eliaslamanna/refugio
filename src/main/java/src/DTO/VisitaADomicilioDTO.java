package src.DTO;

import java.util.Date;

public class VisitaADomicilioDTO {
    private Date fechaVisita;

    private String observaciones;

    private EncuestaDTO encuesta;

    public boolean isTerminada() {
        return terminada;
    }

    private boolean terminada;

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public EncuestaDTO getEncuesta() {
        return encuesta;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setEncuesta(EncuestaDTO encuesta) {
        this.encuesta = encuesta;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }
}
