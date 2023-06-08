package src;

import src.DTO.AnimalDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseDeDatos {

    private static BaseDeDatos instancia;

    private static HashMap<String, AnimalDTO> animales;

    private BaseDeDatos() {
    }

    public static BaseDeDatos getInstancia() {
        if(instancia == null) {
            instancia = new BaseDeDatos();
            animales = new HashMap<>();
        }

        return instancia;
    }

    public void ingresarAnimal(AnimalDTO animal) {
        animales.put(animal.getId(), animal);
    }

    public boolean animalYaExiste(String id) {
        return animales.containsKey(id);
    }

    public List<AnimalDTO> obtenerAnimales() {
        return new ArrayList<>(animales.values());
    }

    public AnimalDTO buscarAnimal(String idAnimal) {
        if (!animales.containsKey(idAnimal)) {
            System.out.println("\n El animal con id " + idAnimal + " no existe en la base de datos\n");
        }

        return animales.get(idAnimal);
    }

}
