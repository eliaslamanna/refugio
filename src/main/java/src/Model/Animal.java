package src.Model;

import src.DTO.TipoAnimal;
import src.Refugio;
import src.DTO.AnimalDTO;

import java.util.UUID;

public class Animal {

    private String id;

    private String nombre;

    private Double altura;

    private Double peso;

    private Integer edadAprox;

    private String condicionMedica;

    private TipoAnimal tipoAnimal;

    public Animal() {
    }

    public Animal(String nombre, Integer edadAprox, Double peso, Double altura, String condicionMedica, TipoAnimal tipoAnimal) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.edadAprox = edadAprox;
        this.peso = peso;
        this.altura = altura;
        this.condicionMedica = condicionMedica;
        this.tipoAnimal = tipoAnimal;
    }

    public void ingresarAnimal(AnimalDTO animal) {
        Animal animalParaGuardar = new Animal(animal.getNombre(), animal.getEdadAprox(), animal.getPeso(), animal.getAltura(), animal.getCondicionMedica(), animal.getTipoAnimal());
        if (Refugio.getInstancia().animalYaExiste(animalParaGuardar)) {
            System.out.println("\n El animal ya existe en la base de datos\n");
        } else {
            Refugio.getInstancia().ingresarAnimal(animalParaGuardar);
            System.out.println(String.format("Se ingreso el animal %s exitosamente.", animal.getNombre()));
        }
    }

    public Animal buscarAnimal(String idAnimal) {
        Animal animalBuscado = Refugio.getInstancia().buscarAnimal(idAnimal);
        if(animalBuscado == null) {
            System.out.println(String.format("No se encontro el animal con id %s.", idAnimal));
        }

        return animalBuscado;
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

}