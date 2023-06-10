package src;

import src.DTO.AdoptanteDTO;
import src.DTO.AnimalDTO;
import src.Model.Adopcion;
import src.Model.Adoptante;
import src.Model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Refugio {

    private static Refugio instancia;

    private static List<Animal> animales;

    private static List<Adoptante> adoptantes;

    private static List<Adopcion> adopciones;

    private Refugio() {
    }

    public static Refugio getInstancia() {
        if(instancia == null) {
            instancia = new Refugio();
            animales = new ArrayList<>();
            adopciones = new ArrayList<>();
            adoptantes = new ArrayList<>();
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

    public void IngresarAdoptante(Adoptante adoptante) { adoptantes.add(adoptante); }
    public void AltaAdopcion(Adopcion adopcion){ adopciones.add(adopcion); }

    public boolean AdoptanteYaExiste(Adoptante adoptante) {
        return adoptantes.contains(adoptante);
    }

    public Adoptante buscarAdoptante(String idAdoptante){
        return adoptantes.stream().filter(animal -> animal.getId().equals(idAdoptante)).findFirst().orElse( null);
    }


}
