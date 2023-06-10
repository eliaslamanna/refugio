package src.DTO;

public class TratamientoDTO {

    private int duracion;

    private String nombre;

    private Boolean finalizado;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setDuracion(int duracion){
        this.duracion = duracion;
    }

    public int getDuracion(){
        return this.duracion;
    }

    public void setFinalizado(Boolean finalizado){
        this.finalizado = finalizado;
    }

    public Boolean getFinalizado(){
        return this.finalizado;
    }

}
