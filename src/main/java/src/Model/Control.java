package src.Model;

import java.util.*;


public class Control {

    private Date momentoDeEjecucion;

    private Veterinario veterinario;

    private List<Accion> acciones;

    private List<Tratamiento> tratamientos;

    public Control(Date momentoDeEjecucion, Veterinario veterinario, List<AccionDTO> acciones, List<TratamientoDTO> tratamientos){
        this.momentoDeEjecucion = momentoDeEjecucion;
        this. veterinario = veterinario;
        //Crear funcion para cargar DTOs en el array de acciones y tratamientos
        this.acciones = acciones;
        this.tratamientos = tratamientos;
    }

}