package src.Model;

import src.DTO.ControlPeriodicoDTO;
import src.Enum.Accion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControlPeriodico {
    private Animal _animal;
    private List<Accion> _acciones;
    private Usuario _atendidoPor;
    private LocalDateTime horaDeAtencion;

    public ControlPeriodico (Animal animal, List<Accion> acciones, Usuario atendidoPor){
        _animal = animal;
        if (acciones == null)
            _acciones = new ArrayList<>();
        else
            _acciones = acciones;
        _atendidoPor = atendidoPor;
    }
    public void agregarAccion(Accion accion){
        _acciones.add(accion);
    }
    public void setAnimal(Animal _animal) {
        this._animal = _animal;
    }
    public Animal getAnimal() {
        return _animal;
    }
    public void setAcciones(List<Accion> acciones) {
        this._acciones = acciones;
    }
    public List<Accion> getAcciones() {
        return _acciones;
    }
    public void setAtendidoPor(Usuario atendidoPor) {
        this._atendidoPor = atendidoPor;
    }
    public Usuario getAtentidoPor() {
        return _atendidoPor;
    }

    public LocalDateTime getHoraDeAtencion() {
        return horaDeAtencion;
    }

    public void setHoraDeAtencion(LocalDateTime horaDeAtencion) {
        this.horaDeAtencion = horaDeAtencion;
    }

    public ControlPeriodicoDTO toDTO(){
        return new ControlPeriodicoDTO(this._animal.toDTO(),this._acciones,this._atendidoPor.toDTO());
    }

    public static ControlPeriodico toObject(ControlPeriodicoDTO controlPeriodicoDTO){
        return new ControlPeriodico(Animal.toObject(controlPeriodicoDTO.getAnimal()), controlPeriodicoDTO.getAcciones()
                ,Usuario.toObject(controlPeriodicoDTO.getAtendidoPor()));
    }
}
