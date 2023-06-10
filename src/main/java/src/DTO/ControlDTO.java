
package src.DTO;

import src.Model.Veterinario;

import java.util.Date;
import java.util.List;


public class ControlDTO {

    private Date momentoDeEjecucion;

    private Veterinario veterinario;

    private List<AccionDTO> acciones;

    private List<TratamientoDTO> tratamientos;

    //GETTER Y SETTERS

    public void setDate(Date momentoDeEjecucion){
        this.momentoDeEjecucion = momentoDeEjecucion;
    }

    public Date getMomentoDeEjecucion(){
        return this.momentoDeEjecucion;
    }

    public void setVeterinario(Veterinario veterinario){
        this.veterinario = veterinario;
    }

    public Veterinario getVeterinario(){
        return this.veterinario;
    }

    public void setAcciones(List<AccionDTO> acciones){
        //this.acciones = acciones;
        this.acciones = acciones;
    }

    public List<AccionDTO> getAcciones(){
        //return this.acciones;
        return this.acciones;
    }

    public void setTratamientos(List<TratamientoDTO> tratamientos){
        //this.tratamientos = tratamientos;
        this.tratamientos = tratamientos;
    }

    public List<TratamientoDTO> getTratamientos(){
        //return this.tratamientos;
        return this.tratamientos;
    }
    

}