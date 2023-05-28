package src.Controller;

import src.DTO.AdoptanteDTO;
import src.Model.Adopcion;
import src.Model.Adoptante;
import src.Model.Animal;

import java.util.*;


public class AdopcionesController {

    private List<Adoptante> adoptantes;

    private List<Adopcion> adopciones;

    private static AdopcionesController instancia;

    private AdopcionesController() {
        this.adopciones = new ArrayList<>();
        this.adoptantes = new ArrayList<>();
    }

    public static AdopcionesController getInstancia() {
        if(instancia == null) {
            instancia = new AdopcionesController();
        }

        return instancia;
    }

    public void altaAdoptante(AdoptanteDTO adoptante) {
        Adoptante modelo = new Adoptante(adoptante);
        modelo.registrarAdoptante();
        adoptantes.add(modelo);
    }

    public void altaAdopcion(AdoptanteDTO adoptante, Animal mascota) {
        // TODO implement here
    }

    public void enviarRecordatorio() {
        // TODO implement here
    }

}