package src.Controller;

import src.DTO.AdoptanteDTO;
import src.DTO.UsuarioDTO;
import src.Model.Animal;
import src.DTO.AnimalDTO;

import java.util.*;


public class AnimalController {
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
        for (Animal animal:
             animales) {
            if (animal.getId().equals(idAnimal)){
                return animal.toDTO();
            }
        }
        return null;
    }


    public AnimalDTO getRandomAnimal(){
        if (animales.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(animales.size());
        return animales.get(randomIndex).toDTO();
    }
}
