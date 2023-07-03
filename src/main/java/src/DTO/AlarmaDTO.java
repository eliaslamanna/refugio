package src.DTO;

import src.Model.TratamientoMedico;

import java.time.LocalDateTime;

public class AlarmaDTO {

    private String idAlarma;
    private int periodicidad;
    private LocalDateTime fechaInicial;

    //private ControlPeriodicoDTO control;
    private ControlPeriodicoDTO controlDeSalud;
    //private TratamientoMedicoDTO tratamientoMedico;

    public AlarmaDTO(int periodicidad, LocalDateTime fechaInicial, ControlPeriodicoDTO controlPeriodico){
        this.periodicidad = periodicidad;
        this.fechaInicial = fechaInicial;
        this.controlDeSalud = controlPeriodico;
    }

    public AlarmaDTO(String idAlarma, int periodicidad, LocalDateTime fechaInicial, ControlPeriodicoDTO controlPeriodico){
        this(periodicidad, fechaInicial, controlPeriodico);
        this.idAlarma = idAlarma;
    }

    public String getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(String idAlarma) {
        this.idAlarma = idAlarma;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDateTime fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public ControlPeriodicoDTO getControlDeSalud() {
        return controlDeSalud;
    }

    public void setControlDeSalud(ControlPeriodicoDTO controlDeSalud) {
        this.controlDeSalud = controlDeSalud;
    }

    public int getPeriodicidad() {
        return this.periodicidad;
    }

    public void setPeriodicidad(int periodicidad){
        this.periodicidad = periodicidad;
    }

    public boolean isTratamientoMedico(){
        boolean isTratamientoMedico = false;

        if (controlDeSalud instanceof TratamientoMedicoDTO)
            isTratamientoMedico = true;

        return isTratamientoMedico;
    }

    public TratamientoMedicoDTO getTratamientoMedico(){
        return (TratamientoMedicoDTO) controlDeSalud;
    }

    public void setTratamientoMedico(TratamientoMedicoDTO tratamientoMedico){
        controlDeSalud = tratamientoMedico;
    }

}
