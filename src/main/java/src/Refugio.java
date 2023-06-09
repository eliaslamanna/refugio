package src;

import src.DTO.AnimalDTO;
import src.Model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Refugio {

    private static Refugio instancia;

    private static List<Animal> animales;

    private Refugio() {
    }

    public static Refugio getInstancia() {
        if(instancia == null) {
            instancia = new Refugio();
            animales = new ArrayList<>();
        }

        return instancia;
    }

    public void ingresarAnimal(Animal animal) {
        animales.add(animal);
    }

    public boolean animalYaExiste(Animal animal) {
        return animales.contains(animal);
    }

    public List<Animal> obtenerAnimales() {
        return animales;
    }

    public Animal buscarAnimal(String idAnimal) {
        return animales.stream().filter(animal -> animal.getId().equals(idAnimal)).findFirst().orElse(null);
    }

}
