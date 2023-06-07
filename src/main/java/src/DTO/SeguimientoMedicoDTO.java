package src.Model;

import src.DTO.AlarmaDTO;

import src.DTO.AnimalDTO;

import java.util.*;


public class SeguimientoMedicoDTO {

    private AnimalDTO animal;

    private List<Alarma> alarmas;

    public SeguimientoMedico(AnimalDTO animal) {
        this.alarmas = new ArrayList<>();
        this.animal = animal;
    }

}