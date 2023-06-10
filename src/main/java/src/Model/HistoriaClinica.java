package src.Model;

import src.DTO.AnimalDTO;
import src.DTO.HistoriaClinicaDTO;

import java.util.*;


public class HistoriaClinica {
    
    private Animal _animal;
    
    private List<Control> intervenciones;
    
    private Seguimiento visitasADomicilio;
    
    private Date fechaDeCreacion;
    
    private Date ultimoCambio;

    public HistoriaClinica (Animal animal, Usuario veterinario){
        _animal = animal;

        //generar los controles para el animal y agregar el veterinario que controla

    }
    public HistoriaClinicaDTO exportarFichaMedica(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

}