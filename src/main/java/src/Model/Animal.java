package src.Model;

import src.DTO.AnimalDTO;

public class Animal {

    private String nombre;

    private float altura;

    private float peso;

    private int edad;

    private String condicionMedica;

    private Boolean esSalvaje;

    private Boolean enTratamiento;

    public Animal(AnimalDTO animalDTO) {
        this.nombre = animalDTO.getNombre();
        this.altura = animalDTO.getAltura();
        this.peso = animalDTO.getPeso();
        this.edad = animalDTO.getEdad();
        this.condicionMedica = animalDTO.getCondicionMedica();
        this.esSalvaje = animalDTO.getEsSalvaje();
        this.enTratamiento = animalDTO.getEnTratamiento();
    }

    public String getNombre() {
        return nombre;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    public int getEdad() {
        return edad;
    }

    public String getCondicionMedica() {
        return condicionMedica;
    }

    public Boolean getEsSalvaje() {
        return esSalvaje;
    }

    public Boolean getEnTratamiento() {
        return enTratamiento;
    }
}