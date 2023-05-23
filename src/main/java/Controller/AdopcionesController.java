package Controller;

import DTO.AdoptanteDTO;
import Model.Adopcion;
import Model.Adoptante;
import Model.Animal;

import java.util.*;

/**
 * 
 */
public class AdopcionesController {

    /**
     * Default constructor
     */
    public AdopcionesController() {
    }

    /**
     * 
     */
    private List<Adoptante> adoptantes;

    /**
     * 
     */
    private List<Adopcion> adopciones;

    /**
     * @param adoptante 
     * @return
     */
    public void altaAdoptante(AdoptanteDTO adoptante) {
        Adoptante modelo = new Adoptante(adoptante);
        modelo.registrarAdoptante();
        adoptantes.add(modelo);
    }

    /**
     * @param adoptante 
     * @param mascota 
     * @return
     */
    public void altaAdopcion(AdoptanteDTO adoptante, Animal mascota) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void enviarRecordatorio() {
        // TODO implement here
    }

}