package src.DTO;

import src.Model.EstrategiaNotificacion;
import src.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SeguimientoDTO {

        private int cadenciaVisita;

        private EstrategiaNotificacion medioNotificacion;

        private Boolean continuarVisitas;

        private int diasRecordatorio;

        private List<VisitaDTO> visitasADomicilio = new ArrayList<>();

        private UsuarioDTO responsable;

    public int getCadenciaVisita() {
        return cadenciaVisita;
    }

    public void setCadenciaVisita(int cadenciaVisita) {
        this.cadenciaVisita = cadenciaVisita;
    }

    public EstrategiaNotificacion getMedioNotificacion() {
        return medioNotificacion;
    }

    public void setMedioNotificacion(EstrategiaNotificacion medioNotificacion) {
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

    public List<VisitaDTO> getVisitasADomicilio() {
        return visitasADomicilio;
    }

    public void setVisitasADomicilio(List<VisitaDTO> visitasADomicilio) {
        this.visitasADomicilio = visitasADomicilio;
    }

    public UsuarioDTO getResponsable() {
        return responsable;
    }

    public void setResponsable(UsuarioDTO responsable) {
        this.responsable = responsable;
    }
}
