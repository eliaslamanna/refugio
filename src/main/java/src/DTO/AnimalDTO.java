package src.DTO;

public class AnimalDTO {

    private String nombre;

    private Double altura;

    private Double peso;

    private Integer edadAprox;

    private String condicionMedica;

    private TipoAnimal tipoAnimal;

    public AnimalDTO(String nombre, Integer edadAprox, Double peso, Double altura, String condicionMedica, TipoAnimal tipoAnimal) {
        this.nombre = nombre;
        this.edadAprox = edadAprox;
        this.peso = peso;
        this.altura = altura;
        this.condicionMedica = condicionMedica;
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombre() {
        return nombre;
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