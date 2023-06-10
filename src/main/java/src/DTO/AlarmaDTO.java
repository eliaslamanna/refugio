package src.DTO;

import java.time.LocalDateTime;

public class AlarmaDTO {

    private LocalDateTime periodicidad;

    private String idControl;

    public LocalDateTime getPeriodicidad() {
        return this.periodicidad;
    }

    public void setPeriodicidad(LocalDateTime periodicidad){
        this.periodicidad = periodicidad;
    }

    public String getControl() {
        return this.idControl;
    }

    public void setControl(String idControl){

        this.idControl = idControl;
    }


}
