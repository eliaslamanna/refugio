package src.DTO;

import java.util.List;


public class SeguimientoMedicoDTO {

    private AnimalDTO animal;

    private List<AlarmaDTO> alarmas;

    public void setAnimal(AnimalDTO animal) {
        this.animal = animal;
    }

    public AnimalDTO getAnimal() {
        return this.animal;
    }




}
