package src.Model;

import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Alarma {

    private String idAlarma;

    private int periodicidadDias;
    private LocalDateTime fechaLimite;

    private Control control;

    public Alarma(int periodicidad, Control control) {

        this.idAlarma = UUID.randomUUID().toString();
        this.periodicidadDias = periodicidad;
        this.fechaLimite = LocalDateTime.now();
        this.fechaLimite.plusDays(periodicidad);
        this.control = control;

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

    public Control getControl(){
        return this.control;
    }

}