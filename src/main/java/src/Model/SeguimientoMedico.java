package src.Model;

import src.DTO.AlarmaDTO;

import java.util.*;


public class SeguimientoMedico {


    private String idSeguimiento;
    private Animal animal;

    private List<Alarma> alarmas;

    public SeguimientoMedico(Animal animal) {
        this.idSeguimiento = UUID.randomUUID().toString();
        this.alarmas = new ArrayList<>();
        this.animal = animal;

    }

    public void agregarAlarma(Alarma alarma){

        this.alarmas.add(alarma);

    }

    public void enviarAlarma(AlarmaDTO alarma) {
        // TODO implement here
    }


    public List<Alarma> getAlarmas(){
        return this.alarmas;
    }

    public String getIdSeguimiento(){
        return idSeguimiento;
    }

}