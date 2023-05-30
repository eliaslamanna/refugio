package src.DTO;

import src.Model.Animal;
import src.Model.Control;
import src.Model.Veterinario;

import java.util.List;

public class AlarmaDTO {

    private int periodicidad;

    private Control control;

    private List<Veterinario> veterinarios;

    private Animal animal;

    private List<String> accionesARealizar;

    public int getPeriodicidad() {
        return periodicidad;
    }

    public Control getControl() {
        return control;
    }

    public List<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public Animal getAnimal() {
        return animal;
    }

    public List<String> getAccionesARealizar() {
        return accionesARealizar;
    }
}
