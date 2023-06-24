package src.Model;

import src.DTO.AnimalDTO;
import src.Enum.TipoAnimal;

import java.util.UUID;

public class Animal {

    private String id;

    private String nombre;

    private Double altura;

    private Double peso;

    private Integer edadAprox;

    private String condicionMedica;

    private TipoAnimal tipoAnimal;

    private boolean enTratamiento;

    public Animal(String nombre, Integer edadAprox, Double peso, Double altura, String condicionMedica, TipoAnimal tipoAnimal) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.edadAprox = edadAprox;
        this.peso = peso;
        this.altura = altura;
        this.condicionMedica = condicionMedica;
        this.tipoAnimal = tipoAnimal;
        this.enTratamiento = false;
    }

    public Animal(String id, String nombre, Integer edadAprox, Double peso, Double altura, String condicionMedica, TipoAnimal tipoAnimal) {
        this(nombre, edadAprox, peso, altura, condicionMedica, tipoAnimal);
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdadAprox() {
        return edadAprox;
    }

    public void setEdadAprox(Integer edadAprox) {
        this.edadAprox = edadAprox;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getCondicionMedica() {
        return condicionMedica;
    }

    public void setCondicionMedica(String condicionMedica) {
        this.condicionMedica = condicionMedica;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public boolean getEnTratamiento(){
        return this.enTratamiento;
    }

    public static Animal toObject(AnimalDTO animalDTO) {
        Animal animal = new Animal(animalDTO.getId(), animalDTO.getNombre(), animalDTO.getEdadAprox(), animalDTO.getPeso()
                , animalDTO.getAltura(), animalDTO.getCondicionMedica(), animalDTO.getTipoAnimal());

        return animal;
    }

    public AnimalDTO toDTO() {
        AnimalDTO animalDTO = new AnimalDTO(this.id,this.nombre,this.edadAprox,this.peso,this.altura
                ,this.condicionMedica,this.tipoAnimal);

        return animalDTO;
    }
}