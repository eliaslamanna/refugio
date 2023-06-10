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

    public int getDuracion() {
        return duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

}