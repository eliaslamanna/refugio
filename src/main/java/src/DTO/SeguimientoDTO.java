package src.DTO;

import src.Enum.MedioRecordatorio;
import src.Model.VisitaADomicilio;

import java.util.ArrayList;
import java.util.List;

public class SeguimientoDTO {

    private int cadenciaVisita;

    private MedioRecordatorio medioNotificacion;

    private Boolean continuarVisitas;

    private int diasRecordatorio;

    private List<VisitaADomicilioDTO> visitasADomicilio = new ArrayList<>();

    private UsuarioDTO responsable;

    public int getCadenciaVisita() {
        return cadenciaVisita;
    }

    public void setCadenciaVisita(int cadenciaVisita) {
        this.cadenciaVisita = cadenciaVisita;
    }

    public MedioRecordatorio getMedioNotificacion() {
        return medioNotificacion;
    }

    public void setMedioNotificacion(MedioRecordatorio medioNotificacion) {
        this.medioNotificacion = medioNotificacion;
    }

    public Boolean getContinuarVisitas() {
        return continuarVisitas;
    }

    public void setContinuarVisitas(Boolean continuarVisitas) {
        this.continuarVisitas = continuarVisitas;
    }

    public int getDiasRecordatorio() {
        return diasRecordatorio;
    }

    public void setDiasRecordatorio(int diasRecordatorio) {
        this.diasRecordatorio = diasRecordatorio;
    }

    public List<VisitaADomicilioDTO> getVisitasADomicilio() {
        return visitasADomicilio;
    }

    public void setVisitasADomicilio(List<VisitaADomicilioDTO> visitasADomicilio) {
        this.visitasADomicilio = visitasADomicilio;
    }

    public UsuarioDTO getResponsable() {
        return responsable;
    }

    public void setResponsable(UsuarioDTO responsable) {
        this.responsable = responsable;
    }

    public List<VisitaADomicilioDTO> getVisitasADomicilioTerminadas() {
        List<VisitaADomicilioDTO> visitasTerminadas =  new ArrayList<>();

        for (VisitaADomicilioDTO visitaADomicilio : visitasADomicilio) {
            if (visitaADomicilio.isTerminada())
                visitasTerminadas.add(visitaADomicilio);
        }

        return visitasTerminadas;
    }

}
