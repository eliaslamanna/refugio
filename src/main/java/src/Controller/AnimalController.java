package src.Controller;

import src.DTO.TipoAnimal;
import src.DTO.UsuarioDTO;
import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;

public class AnimalController {


    private List<Animal> animales;

    private static AnimalController instancia;

    private AnimalController() {
        animales = new ArrayList<>() {
        };
    }

    public static AnimalController getInstancia() {
        if(instancia == null) {
            instancia = new AnimalController();
        }

        return instancia;
    }

    public void ingresarAnimal(AnimalDTO animalDTO) {
        Animal newAnimal = new Animal(animalDTO.getNombre(), animalDTO.getEdadAprox(), animalDTO.getPeso(), animalDTO.getAltura(), animalDTO.getCondicionMedica(), animalDTO.getTipoAnimal());
        this.animales.add(newAnimal);
    }

    public Animal buscarAnimal(String idAnimal) {
        for (Animal animal:animales){
            if (animal.getId()== idAnimal){
                return animal;
            }
        }
        return null;
    }

    public List<Animal> getAnimales() {
        return animales;
    }
}
