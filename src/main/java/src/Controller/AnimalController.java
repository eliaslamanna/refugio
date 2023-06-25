package src.Controller;

import src.DTO.UsuarioDTO;
import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;


public class AnimalController {

    private Animal animal;
    private static AnimalController instancia;
    private static List<Animal> animales;

    private AnimalController() {
        animales = new ArrayList<>();
    }

    public static AnimalController getInstancia() {
        if(instancia == null) {
            instancia = new AnimalController();
        }
        return instancia;
    }

    public void ingresarAnimal(AnimalDTO animal, UsuarioDTO veterinario) {
            Animal animalParaGuardar = new Animal(animal.getNombre(), animal.getEdadAprox(), animal.getPeso(), animal.getAltura(), animal.getCondicionMedica(), animal.getTipoAnimal());

            animales.add(animalParaGuardar);
            ClinicaController.getInstancia().crearHistoriaClinica(animalParaGuardar.toDTO(), veterinario);
            System.out.println(String.format("Se ingreso el animal %s exitosamente.", animal.getNombre()));
    }

    public List<AnimalDTO> getAnimales() {
        List<AnimalDTO> listaAnimales = new ArrayList<>();
        for (Animal animal : this.animales) {
            listaAnimales.add(animal.toDTO());
        }
        return listaAnimales;
    }

    public AnimalDTO getAnimalPorId(String idAnimal) {
        return animales.stream().filter(animal -> animal.getId().equals(idAnimal)).findFirst().orElse(null).toDTO();
    }

    public List<AnimalDTO> getAnimalesDisponibles(){
        List <AnimalDTO> animalesDisponibles = new ArrayList<>();
        for (Animal animal : animales) {
            if(!animal.getEnTratamiento()){
                animalesDisponibles.add(animal.toDTO());
            }
        }
        return animalesDisponibles;
    }
}
