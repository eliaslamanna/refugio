package src.Controller;

import src.DTO.TipoAnimal;
import src.DTO.UsuarioDTO;
import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;


public class AnimalController {

    private Animal animal;
    private static AnimalController instancia;
    private static List<Animal> animalesDomesticos;
    private static List<Animal> animalesSalvajes;

    private AnimalController() {
        animalesDomesticos = new ArrayList<>();
        animalesSalvajes = new ArrayList<>();
    }

    public static AnimalController getInstancia() {
        if (instancia == null){
            instancia = new AnimalController();
        }
        return instancia;
    }

    public void ingresarAnimal(AnimalDTO animal, UsuarioDTO veterinario) {
        Animal animalParaGuardar = new Animal(animal.getNombre(), animal.getEdadAprox(), animal.getPeso(), animal.getAltura(), animal.getCondicionMedica(), animal.getTipoAnimal());
        if (this.animalYaExiste(animalParaGuardar)) {
            System.out.println("\n El animal ya existe en la base de datos\n");
        } else {
            if ((animal.getTipoAnimal().equals(TipoAnimal.DOMESTICO)))
                animalesDomesticos.add(animalParaGuardar);
            else
                animalesSalvajes.add(animalParaGuardar);
            ClinicaController.getInstancia().crearHistoriaClinica(animal, veterinario);
            System.out.println(String.format("Se ingreso el animal %s exitosamente.", animal.getNombre()));
        }
    }

    public boolean animalYaExiste(Animal animal) {
        return animalesDomesticos.contains(animal);
    }

    public List<Animal> obtenerAnimales() {
        return animalesDomesticos;
    }

    public Animal buscarAnimal(String idAnimal) {
        return animalesDomesticos.stream().filter(animal -> animal.getId().equals(idAnimal)).findFirst().orElse(null);
    }

}
