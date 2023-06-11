package src.Controller;

import src.DTO.TipoAnimal;
import src.DTO.UsuarioDTO;
import src.Model.Animal;
import src.DTO.AnimalDTO;
import src.Model.Usuario;

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
        Usuario veterniarioParaAsignar = UsuarioController.getInstancia().getUsuarioPorId(veterinario.getIdUsuario());
        if (this.animalYaExiste(animalParaGuardar)) {
            System.out.println("\n El animal ya existe en la base de datos\n");
        } else {
            animales.add(animalParaGuardar);
            ClinicaController.getInstancia().crearHistoriaClinica(animalParaGuardar, veterniarioParaAsignar);
            System.out.println(String.format("Se ingreso el animal %s exitosamente.", animal.getNombre()));
        }
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


    public List<Animal> getAnimales() {
        return animales;
    }


}
