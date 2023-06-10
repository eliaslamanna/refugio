package src.Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Alarma {

    private String idAlarma;
    private LocalDateTime periodicidad;

    private Control control;

    public Alarma(LocalDateTime periodicidad, Control control) {

        this.idAlarma = UUID.randomUUID().toString();
        this.periodicidad = periodicidad;
        this.control = control;

    }


    public LocalDateTime getPeriodicidad(){
        return periodicidad;
    }

    public String getIdAlarma(){
        return idAlarma;
    }

}