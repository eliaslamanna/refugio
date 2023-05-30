package src.DTO;

import java.util.*;


public class AnimalDTO {

    private String nombre;

    private Float altura;
    
    private Float peso;

    private int edad;

    private String condicionMedica;

    private Boolean esSalvaje;

    private Boolean enTratamiento;

    public AnimalDTO(String nombre, Float altura, Float peso, int edad, String condicionMedica, Boolean esSalvaje, Boolean enTratamiento) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
        this.condicionMedica = condicionMedica;
        this.esSalvaje = esSalvaje;
        this.enTratamiento = enTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getPeso() {
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