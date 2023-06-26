
package src.DTO;

import src.Model.Usuario;

import java.util.Date;
import java.util.List;


public class ControlDTO {

    private Date momentoDeEjecucion;
    private Usuario veterinario;
    private List<AccionDTO> acciones;
    private List<TratamientoDTO> tratamientos;

    //GETTER Y SETTERS

    public void setDate(Date momentoDeEjecucion){
        this.momentoDeEjecucion = momentoDeEjecucion;
    }

    public Date getMomentoDeEjecucion(){
        return this.momentoDeEjecucion;
    }

    public void setVeterinario(Usuario veterinario){
        this.veterinario = veterinario;
    }

    public Usuario getVeterinario(){
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