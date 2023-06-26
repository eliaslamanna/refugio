package src.Model;

import src.DTO.AlarmaDTO;
import src.DTO.TratamientoMedicoDTO;
import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Alarma {
    private String idAlarma;
    private int periodicidadDias;
    private LocalDateTime fechaInicial;
    private ControlPeriodico control;
    private EstadoAlarma estadoAlarma;

    public Alarma(int periodicidad, LocalDateTime fechaInicial, ControlPeriodico control) {
        this.idAlarma = UUID.randomUUID().toString();
        this.periodicidadDias = periodicidad;
        this.fechaInicial = fechaInicial;
        this.control = control;
    }

    public Alarma(String id, int periodicidad, LocalDateTime fechaInicial, ControlPeriodico control) {
        this(periodicidad, fechaInicial, control);
        if (id != null)
            this.idAlarma = id;
    }

    public int getPeriodicidad(){
        return periodicidadDias;
    }
    public String getIdAlarma(){
        return idAlarma;
    }
    public LocalDateTime getFechaInicial(){
        return fechaInicial;
    }
    public List<Accion> getAccionesDeControl(){
        return control.getAcciones();
    }
    public ControlPeriodico getControl(){
        return this.control;
    }

    public AlarmaDTO toDTO(){
        return new AlarmaDTO(this.idAlarma, this.periodicidadDias, this.fechaInicial, control.toDTO());
    }

    public static Alarma toObject(AlarmaDTO alarmaDTO){
        Alarma alarma = null;
        if (alarmaDTO.getControlDeSalud() instanceof TratamientoMedicoDTO)
            alarma = new Alarma(alarmaDTO.getIdAlarma(), alarmaDTO.getPeriodicidad(), alarmaDTO.getFechaInicial()
                    ,TratamientoMedico.toObject(alarmaDTO.getControlDeSalud()));
        else
            alarma = new Alarma(alarmaDTO.getIdAlarma(), alarmaDTO.getPeriodicidad(), alarmaDTO.getFechaInicial()
                    ,ControlPeriodico.toObject(alarmaDTO.getControlDeSalud()));

        return alarma;
    }

    public void atenderAlarma(Usuario atendidoPor){
        this.estadoAlarma.atenderAlarma(this,atendidoPor);
    }

    public boolean isAtendible(){
        boolean isAtendible = false;
        if (fechaInicial.isBefore(LocalDateTime.now())){
            isAtendible = true;
        }
        return isAtendible;
    }

}