package src.DTO;

public class AnimalXAlarmaDTO {

    private String idAnimal;

    private String nombreAnimal;

    private int cantAlarmas;


    public AnimalXAlarmaDTO(String id, String nombre, int cantidad){
        this.nombreAnimal = nombre;
        this.idAnimal = id;
        this.cantAlarmas = cantidad;
    }

    public void setIdAnimal(String id){
        this.idAnimal = id;
    }

    public String getIdAnimal(){
        return this.idAnimal;
    }

    public void setNombreAnimal(String nombre){
        this.nombreAnimal = nombre;
    }

    public String getNombreAnimal(){
        return this.nombreAnimal;
    }

    public void setCantAlarmas(int cantidad){
        this.cantAlarmas = cantidad;
    }

    public int getCantAlarmas(){
        return this.cantAlarmas;
    }



}
