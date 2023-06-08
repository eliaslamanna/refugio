package src.Model;

import src.BaseDeDatos;
import src.DTO.AnimalDTO;

public class Animal {

    public void ingresarAnimal(AnimalDTO animalDTO) {
        if (BaseDeDatos.getInstancia().animalYaExiste(animalDTO.getId())) {
            System.out.println("\n El animal ya existe en la base de datos\n");
        }else {
            registrarAnimal(animalDTO);
        }
    }

    public void registrarAnimal(AnimalDTO animal) {
        BaseDeDatos.getInstancia().ingresarAnimal(animal);
        System.out.println(String.format("Se ingreso el animal %s con id %s exitosamente.", animal.getNombre(), animal.getId()));
    }

    public AnimalDTO buscarAnimal(String idAnimal) {
        return BaseDeDatos.getInstancia().buscarAnimal(idAnimal);
    }

}