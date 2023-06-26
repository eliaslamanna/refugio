package src.Model;

import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Alarma {
    private String idAlarma;
    private int periodicidadDias;
    private LocalDateTime fechaLimite;
    private ControlPeriodico control;

    public Alarma(int periodicidad, ControlPeriodico control) {
        this.idAlarma = UUID.randomUUID().toString();
        this.periodicidadDias = periodicidad;
        this.fechaLimite = LocalDateTime.now();
        this.fechaLimite.plusDays(periodicidad);
        this.control = control;
    }

    public Alarma(String id, int periodicidad, ControlPeriodico control) {
        this(periodicidad, control);
        if (id != null)
            this.idAlarma = id;
    }

    public int getPeriodicidad(){
        return periodicidadDias;
    }
    public String getIdAlarma(){
        return idAlarma;
    }
    public LocalDateTime getFechaLimite(){
        return fechaLimite;
    }
    public List<Accion> getAccionesDeControl(){
        return control.getAcciones();
    }
    public ControlPeriodico getControl(){
        return this.control;
    }

}