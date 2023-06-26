package src.Model;

import src.Enum.Accion;

import java.util.ArrayList;
import java.util.List;

public abstract class ControlPeriodico {
    private Animal _animal;
    private List<Accion> _acciones;
    private Usuario _veterinario;

    public ControlPeriodico (){
        _acciones = new ArrayList<>();
    }
    public void agregarAccion(Accion accion){
        _acciones.add(accion);
    }
    public Animal getAnimal() {
        return _animal;
    }
    public void setAnimal(Animal _animal) {
        this._animal = _animal;
    }
    public List<Accion> getAcciones() {
        return _acciones;
    }
    public Usuario getVeterinario() {
        return _veterinario;
    }
    public void setVeterinario(Usuario veterinario) {
        this._veterinario = veterinario;
    }
}
