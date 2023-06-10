package src.Model;

public class Tratamiento {

    private int duracion;

    private String nombre;

    private Boolean finalizado;

    public void Tratamiento(int duracion, String nombre, Boolean finalizado){

        this.duracion = duracion;
        this.nombre = nombre;
        this.finalizado = finalizado;
    }

}