package src.Model;

import src.DTO.AlarmaDTO;
import src.DTO.AnimalDTO;

import java.time.LocalDateTime;
import java.util.*;


public class SeguimientoMedico {


    private String idSeguimiento;
    private Animal animal;

    private List<Alarma> alarmas;

    private List<Alarma> alarmasActivas;

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

    public Animal getAnimal(){
        return this.animal;
    }


    public List<Alarma> getAlarmas(){
        return this.alarmas;
    }

    public String getIdSeguimiento(){
        return idSeguimiento;
    }

    public int buscarAlarmasActivas(){
        alarmasActivas.clear();
        LocalDateTime fechaActual = LocalDateTime.now();
        for (int i = 0; i < alarmas.size(); i ++){
            if(alarmas.get(i).getFechaLimite().isBefore(fechaActual)){
                alarmasActivas.add(alarmas.get(i));
            }
        }
        return this.getCantidadAlarmasActivas();
    }

    public int getCantidadAlarmasActivas(){
        return alarmasActivas.size();
    }

    public String getIdAnimal(){
        return this.animal.getId();
    }

    public List<Alarma> getAlarmasActivas(){
        return this.alarmasActivas;
    }

    public void removarAlarma(String idAlarma){
        int i = 0;
        boolean alarmaEncontrada = false;
        while (i < alarmas.size() && alarmaEncontrada == false){
            if(alarmas.get(i).getIdAlarma().equals(idAlarma)){
                alarmas.remove(i);
                alarmaEncontrada = true;
            }
            i = i + 1 ;
        }

    }

}