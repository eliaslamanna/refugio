package src.Model;

import java.util.Date;
import java.util.List;


public class AlarmaControl extends Alarma {

    private Date momentoDeEjecucion;

    private Veterinario veterinario;

    private List<Accion> acciones;

    private List<Tratamiento> tratamientos;

    public AlarmaControl(int periodicidad, Control control, List<Observer> veterinarios, Animal animal, List<String> accionesARealizar) {
        super(periodicidad, control, veterinarios, animal, accionesARealizar);
    }

}