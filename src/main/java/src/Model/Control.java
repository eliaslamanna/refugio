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

}