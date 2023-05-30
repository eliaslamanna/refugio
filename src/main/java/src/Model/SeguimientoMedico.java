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

    public void añadirAlarma(String tipoAlarma, AlarmaDTO alarmaDTO) {
        // TODO generar con factory segun el tipo de alarma con los datos de la alarma
        //this.alarmas.add(new Alarma(alarmaDTO.getPeriodicidad(), alarmaDTO.getControl(), alarmaDTO.getVeterinarios(), alarmaDTO.getAnimal(), alarmaDTO.getAccionesARealizar()));
    }

    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }

}