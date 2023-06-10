package src.Controller;

import src.DTO.AdoptanteDTO;
import src.DTO.AnimalDTO;
import src.Model.Adopcion;
import src.Model.Adoptante;
import src.Model.Animal;

import java.util.*;


public class AdopcionesController {

    private Adoptante adoptante;
    private Adopcion adopcion;


    private AdopcionesController() { adoptante = new Adoptante(); }


    public void ingresarAdoptante(AdoptanteDTO adoptanteDTO) {
        adoptante.AltaAdoptante(adoptanteDTO);
    }

    public void altaAdopcion(String IdAdoptante,String Idanimal) {
        adopcion.CrearAdopcion(IdAdoptante, Idanimal);
    }

    public void enviarRecordatorio() {
        // TODO implement here
    }

}