package src.Model;

import src.DTO.AlarmaDTO;

import java.util.*;


public class SeguimientoMedico {

    private Animal animal;

    private List<Alarma> alarmas;

    public SeguimientoMedico(Animal animal) {
        this.alarmas = new ArrayList<>();
        this.animal = animal;
    }

    public void añadirAlarma(AlarmaDTO alarmaDTO) {
        this.alarmas.add(new Alarma(alarmaDTO.getPeriodicidad(), alarmaDTO.getControl()));
    }

    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }

}