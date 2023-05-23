package Model;

import DTO.AnimalDTO;
import DTO.HistoriaClinicaDTO;

import java.util.*;

/**
 * 
 */
public class HistoriaClinica {

    /**
     * Default constructor
     */
    public HistoriaClinica() {
    }

    /**
     * 
     */
    private Animal animal;

    /**
     * 
     */
    private List <Control> intervenciones;

    /**
     * 
     */
    private Seguimiento visitasADomicilio;

    /**
     * 
     */
    private Date fechaDeCreacion;

    /**
     * 
     */
    private Date ultimoCambio;

    /**
     * @param animal 
     * @return
     */
    public HistoriaClinicaDTO exportarFichaMedica(AnimalDTO animal) {
        // TODO implement here
        return null;
    }

}