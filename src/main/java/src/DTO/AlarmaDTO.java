package src.DTO;

import java.time.LocalDateTime;

public class AlarmaDTO {

    private int periodicidad;

    private String idControl;



    public int getPeriodicidad() {
        return this.periodicidad;
    }

    public void setPeriodicidad(int periodicidad){
        this.periodicidad = periodicidad;
    }

    public String getControl() {
        return this.idControl;
    }

    public void setControl(String idControl){

        this.idControl = idControl;
    }


}
