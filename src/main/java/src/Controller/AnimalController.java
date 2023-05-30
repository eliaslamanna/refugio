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

    public void altaAnimal(AnimalDTO animalDTO) {
        Animal animal = new Animal(animalDTO);
        animales.add(animal);

        System.out.println("Se agrego al animal " + animal.getNombre() + " con exito.");
        System.out.println("\n");
    }

    public List<Animal> getAnimales() {
        return animales;
    }

}