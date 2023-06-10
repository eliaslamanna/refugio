package src.Model;

import src.DTO.AccionDTO;
import src.DTO.TratamientoDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Control {

    private String idControl;

    private Date momentoDeEjecucion;

    private Usuario veterinario;

    private List<Accion> acciones;

    private List<TratamientoDTO> tratamientos;

    public Control(Date momentoDeEjecucion, Veterinario veterinario, List<AccionDTO> acciones, List<TratamientoDTO> tratamientos){
        this.idControl = UUID.randomUUID().toString();
        this.momentoDeEjecucion = momentoDeEjecucion;
        this. veterinario = veterinario;
        //Crear funcion para cargar DTOs en el array de acciones y tratamientos
        //Accion nuevaAccion = Accion()
        //this.acciones = acciones;
        this.tratamientos = tratamientos;
    }

    public String getIdControl(){
        return idControl;
    }

    public void setMomentoDeEjecucion(Date momentoDeEjecucion) {
        this.momentoDeEjecucion = momentoDeEjecucion;
    }

    public void setVeterinario(Usuario veterinario) {
        this.veterinario = veterinario;
    }

    public void setAcciones(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public Date getMomentoDeEjecucion() {
        return momentoDeEjecucion;
    }

    public Usuario getVeterinario() {
        return veterinario;
    }

    public List<Accion> getAcciones() {
        return acciones;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }
}