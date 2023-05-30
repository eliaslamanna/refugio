package src.Model;

import src.DTO.AlarmaDTO;

import java.util.ArrayList;
import java.util.List;


public class AlarmaSeguimientoMedico extends Alarma {
     // -> cambio anterior
    /*private Animal animal;

    private List<Alarma> alarmas;*/

    private Boolean tratamientoFinalizo;

    public AlarmaSeguimientoMedico(int periodicidad, Control control, List<Observer> veterinarios, Animal animal, List<String> accionesARealizar) {
        super(periodicidad, control, veterinarios, animal, accionesARealizar);
    }

    @Override
    public void actualizar(Boolean finalizo) {
        super.actualizar(finalizo);

        // TODO cuando es que el veterinario finaliza un tratamiento?
        if(finalizo) {
            this.setTratamientoFinalizo(true);
        }
    }

    public void setTratamientoFinalizo(Boolean tratamientoFinalizo) {
        this.tratamientoFinalizo = tratamientoFinalizo;
    }
    
}