package src.Controller;

import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;


public class AnimalController {

    private List<Animal> animales;

    private static AnimalController instancia;

    private AnimalController() {
        this.animales = new ArrayList<>();
    }

    public static AnimalController getInstancia() {
        if(instancia == null) {
            instancia = new AnimalController();
        }

        return instancia;
    }

    public void altaAnimal(AnimalDTO animal) {
        // TODO implement here
    }

}