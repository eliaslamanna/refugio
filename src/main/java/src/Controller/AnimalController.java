package src.Controller;

import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;


public class AnimalController {

    private Animal animal;

    public AnimalController() {
        animal = new Animal();
    }

    public void ingresarAnimal(AnimalDTO animalDTO) {
        animal.ingresarAnimal(animalDTO);
    }

    public AnimalDTO buscarAnimal(String idAnimal) {
        return animal.buscarAnimal(idAnimal);
    }

}